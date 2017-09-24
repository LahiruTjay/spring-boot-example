package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void saveUser(@RequestBody SystemUserDto systemUserDto) {
		userService.save(systemUserDto);
	}

}
