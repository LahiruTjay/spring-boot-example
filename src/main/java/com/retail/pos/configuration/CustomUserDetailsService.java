package com.retail.pos.configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.retail.pos.entity.Role;
import com.retail.pos.entity.RoleAuthority;
import com.retail.pos.entity.SystemUser;
import com.retail.pos.exception.CurrentRoleNotFoundException;
import com.retail.pos.repository.RoleAuthorityRepository;
import com.retail.pos.repository.RoleRepository;
import com.retail.pos.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleAuthorityRepository roleAuthorityRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {

			SystemUser user = userRepository.findByUsernameIgnoreCase(username);

			return new User(user.getUsername(),user.getPassword() , getGrantedAuthoritiesForUser(user));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public Set<GrantedAuthority> getGrantedAuthoritiesForUser(SystemUser user) {

		Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		String userRole = user.getRole().getRoleName();

		if (userRole != null) {

			Role role = roleRepository.findByRoleName(userRole);

			if (role != null) {

				List<RoleAuthority> roleAuthorities = roleAuthorityRepository.findAllByRole(role);

				for (RoleAuthority roleAuthority : roleAuthorities) {
					grantedAuthoritySet.add(new SimpleGrantedAuthority(roleAuthority.getAuthority().getAuthority()));
				}
				return grantedAuthoritySet;
			} else {
				throw new CurrentRoleNotFoundException();
			}
		} else {
			throw new CurrentRoleNotFoundException();
		}

	}
}
