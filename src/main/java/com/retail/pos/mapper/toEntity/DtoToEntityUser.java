package com.retail.pos.mapper.toEntity;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.entity.Role;
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

}
