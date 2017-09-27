package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

}
