package com.retail.pos.service;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.dto.response.ApiResponse;

public interface UserService {

	public ApiResponse save(SystemUserDto systemUserDto);

}
