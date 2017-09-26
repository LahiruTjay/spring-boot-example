package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Role;
import com.retail.pos.entity.SystemUser;
import com.retail.pos.mapper.toEntity.DtoToEntityUser;
import com.retail.pos.repository.UserRepository;
import com.retail.pos.service.RoleService;
import com.retail.pos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleService roleService;

	@Override
	public GenericApiResponse save(SystemUserDto systemUserDto) {

		try {
			SystemUser existingUser = userRepository.findByUsername(systemUserDto.getUsername());

			if (existingUser != null) {

				Role role = roleService.findRoleById(systemUserDto.getRoleId());

				SystemUser systemUser = DtoToEntityUser.getUser(systemUserDto, role);
				
				// userRepository.save(systemUser);
				
				return new GenericApiResponse("", "", systemUser);

			} else {

			}
		} catch (Exception e) {

		}

		return null;
	}

}
