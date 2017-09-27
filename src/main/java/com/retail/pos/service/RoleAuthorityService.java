package com.retail.pos.service;

import com.retail.pos.dto.request.RoleAuthorityDto;
import com.retail.pos.dto.response.GenericApiResponse;

public interface RoleAuthorityService {
	
	public GenericApiResponse saveRoleAuthorities(RoleAuthorityDto roleAuthorityDto);

}
