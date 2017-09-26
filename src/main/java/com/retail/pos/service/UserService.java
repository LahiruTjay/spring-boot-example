package com.retail.pos.service;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.dto.response.GenericApiResponse;

public interface UserService {

	public GenericApiResponse save(SystemUserDto systemUserDto);

}
