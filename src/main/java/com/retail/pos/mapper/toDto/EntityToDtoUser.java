package com.retail.pos.mapper.toDto;

import com.retail.pos.dto.request.AuthorityDto;
import com.retail.pos.dto.request.RoleDto;
import com.retail.pos.entity.Authority;
import com.retail.pos.entity.Role;

public class EntityToDtoUser {

	public static AuthorityDto getAuthorityDto(Authority authority) {
		AuthorityDto authorityDto = new AuthorityDto();
		authorityDto.setId(authority.getId());
		authorityDto.setAuthority(authority.getAuthority());
		return authorityDto;
	}

	public static RoleDto getRoleDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setRoleName(role.getRoleName());
		return roleDto;
	}

}
