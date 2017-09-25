package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.repository.UserRepository;
import com.retail.pos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(SystemUserDto systemUserDto) {
		
		System.out.println(systemUserDto.getFirstName());
		
		//TODO Add the implementation
		
	}

}
