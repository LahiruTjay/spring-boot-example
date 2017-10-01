package com.retail.pos.service;

import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Authority;

public interface AuthorityService {
	
	public GenericApiResponse getAllAuthorities();
	
	public void saveAuthority(Authority authority);

}
