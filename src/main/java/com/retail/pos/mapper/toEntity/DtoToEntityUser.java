package com.retail.pos.mapper.toEntity;

import java.util.Date;

import com.retail.pos.dto.request.AuthorityDto;
import com.retail.pos.dto.request.RoleAuthorityDto;
import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.entity.Authority;
import com.retail.pos.entity.Role;
import com.retail.pos.entity.RoleAuthority;
import com.retail.pos.entity.SystemUser;

public class DtoToEntityUser {

	public static SystemUser getUser(SystemUserDto systemUserDto, Role role) {
		SystemUser systemUser = new SystemUser();
		systemUser.setUsername(systemUserDto.getUsername());
		systemUser.setFirstName(systemUserDto.getFirstName());
		systemUser.setLastName(systemUserDto.getLastName());
		systemUser.setRole(role);
		return systemUser;
	}
	
	public static Role getRole(RoleAuthorityDto roleAuthorityDto) {
		Role role = new Role();
		role.setRoleName(roleAuthorityDto.getRoleName());
		role.setCreatedDate(new Date());
		role.setLastUpdatedDate(new Date());
		return role;
	}

	public static Authority getAuthority(AuthorityDto authorityDto) {
		Authority authority = new Authority();
		authority.setAuthority(authorityDto.getAuthority());
		authority.setCreatedDate(new Date());
		authority.setLastUpdatedDate(new Date());
		return authority;
	}
	
	public static RoleAuthority getRoleAuthority(Role role, Authority authority) {
		RoleAuthority roleAuthority = new RoleAuthority();
		roleAuthority.setRole(role);
		roleAuthority.setAuthority(authority);
		roleAuthority.setCreatedDate(new Date());
		roleAuthority.setLastUpdatedDate(new Date());
		return roleAuthority;
	}
}
