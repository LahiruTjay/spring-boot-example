package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.entity.Role;
import com.retail.pos.repository.RoleRepository;
import com.retail.pos.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role findRoleById(int roleId) {
		return roleRepository.findOne(roleId);
	}
}
