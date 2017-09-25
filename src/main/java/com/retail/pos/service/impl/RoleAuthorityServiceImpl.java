package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.repository.RoleAuthorityRepository;
import com.retail.pos.service.RoleAuthorityService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	@Autowired
	RoleAuthorityRepository roleAuthorityRepository;
}
