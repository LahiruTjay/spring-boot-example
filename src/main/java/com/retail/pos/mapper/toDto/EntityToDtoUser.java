package com.retail.pos.mapper.toDto;

import com.retail.pos.dto.request.AuthorityDto;
import com.retail.pos.entity.Authority;

public class EntityToDtoUser {
	
	public static AuthorityDto getAuthorityDto(Authority authority) {
		AuthorityDto authorityDto = new AuthorityDto();
		authorityDto.setId(authority.getId());
		authorityDto.setAuthority(authority.getAuthority());
		return authorityDto;
	}

}
