package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.pos.constant.CommonConstants;
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
	@Transactional
	public GenericApiResponse save(SystemUserDto systemUserDto) {

		try {
			SystemUser existingUser = userRepository.findByUsername(systemUserDto.getUsername());

			if (existingUser != null) {

				Role role = roleService.findRoleById(systemUserDto.getRoleId());

				SystemUser systemUser = DtoToEntityUser.getUser(systemUserDto, role);

				userRepository.save(systemUser);

				return new GenericApiResponse(CommonConstants.STATUS_SUCCESSFULL,
						CommonConstants.USER_SUCCESSFULLY_CREATED, systemUser);

			} else {
				return new GenericApiResponse(CommonConstants.STATUS_FAILED,
						CommonConstants.USERNAME_ALREADY_AVAILABLE);
			}
		} catch (Exception e) {
			return new GenericApiResponse(CommonConstants.STATUS_FAILED, e.getMessage());
		}
	}

}
