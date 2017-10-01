package com.retail.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.constant.CommonConstants;
import com.retail.pos.dto.request.RoleDto;
import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Role;
import com.retail.pos.mapper.toDto.EntityToDtoUser;
import com.retail.pos.repository.RoleRepository;
import com.retail.pos.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public GenericApiResponse getAllRoles() {

		try {
			
			List<RoleDto> roleDtoList = roleRepository.findAll().stream().map(EntityToDtoUser::getRoleDto).collect(Collectors.toList());
			
			return new GenericApiResponse(CommonConstants.STATUS_SUCCESSFULL, CommonConstants.STATUS_SUCCESSFULL, roleDtoList);
		
		} catch (Exception e) {
			return new GenericApiResponse(CommonConstants.STATUS_FAILED, e.getMessage());
		}
	}

	@Override
	public Role findRoleById(int roleId) {
		return roleRepository.findOne(roleId);
	}

	@Override
	public void createRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role findRoleByName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

}
