package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.entity.Authority;
import com.retail.pos.repository.AuthorityRepository;
import com.retail.pos.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public void saveAuthority(Authority authority) {
		authorityRepository.save(authority);
	}
}
