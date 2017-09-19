package com.retail.pos.configuration;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.retail.pos.entity.SystemUser;
import com.retail.pos.exception.CurrentRoleNotFoundException;
import com.retail.pos.repository.UserRepository;

@Service
public class CustomAuthManager implements AuthenticationManager {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String authType = request.getParameter("auth_type");

		if (authType != null) {

			if (authType.equals("mobile")) {

				String fitId = request.getParameter("username");
				String password = request.getParameter("password");

				SystemUser user = userRepository.findByUsernameIgnoreCase(fitId);

				if (user != null) {

					if (password.equals(user.getPassword())) {

						// Give grant permission
						return retrieveToken(user);

					} else {
						throw new BadCredentialsException("Invalid credentials");
					}

				} else {
					throw new BadCredentialsException("Invalid credentials");
				}
			}
		}
		return null;
	}

	private UsernamePasswordAuthenticationToken retrieveToken(SystemUser user) {

		Set<GrantedAuthority> grantedAuthoritySet = customUserDetailsService.getGrantedAuthoritiesForUser(user);

		if (!grantedAuthoritySet.isEmpty()) {
			return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), grantedAuthoritySet);
		} else {
			throw new CurrentRoleNotFoundException();
		}

	}

	/*private UsernamePasswordAuthenticationToken fromUserDetails(SystemUser user) {

		String defaultRole = user.getDefaultRole();

		if (defaultRole != null) {

			System.out.println("UsernamePasswordAuthenticationToken currentRole != null)");

			// Need to get the authorities for the current role and grant them
			Role role = roleRepository.findByRoleName(defaultRole);

			if (role != null) {

				System.out.println("UsernamePasswordAuthenticationToken role != null)");
				List<RoleAuthority> roleAuthorities = roleAuthorityRepository.findAllByRole(role);

				Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();

				for (RoleAuthority roleAuthority : roleAuthorities) {

					System.out.println("authority to be granted " + roleAuthority.getAuthority());
					grantedAuthoritySet.add(new SimpleGrantedAuthority(roleAuthority.getAuthority()));
				}

				return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
						grantedAuthoritySet);

			} else {

				System.out.println("UsernamePasswordAuthenticationToken role == null)");

				throw new CurrentRoleNotFoundException();
			}

		} else {
			System.out.println("UsernamePasswordAuthenticationToken currentRole == null)");
			throw new CurrentRoleNotFoundException();
		}

	}*/

}
