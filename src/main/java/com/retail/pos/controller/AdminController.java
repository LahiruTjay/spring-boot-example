package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.dto.request.RoleAuthorityDto;
import com.retail.pos.dto.request.SystemUserDto;
import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.service.AuthorityService;
import com.retail.pos.service.RoleAuthorityService;
import com.retail.pos.service.RoleService;
import com.retail.pos.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthorityService authorityService;

	@Autowired
	RoleService roleService;

	@Autowired
	RoleAuthorityService roleAuthorityService;

	@Autowired
	UserService userService;

	// AUTHORITIES RELATED
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/authorities", method = RequestMethod.GET)
	public GenericApiResponse getAllAuthorities() {
		return authorityService.getAllAuthorities();
	}

	// ROLES RELATED

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public GenericApiResponse createRole(@RequestBody RoleAuthorityDto roleAuthorityDto) {
		return roleAuthorityService.saveRoleAuthorities(roleAuthorityDto);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public GenericApiResponse getAllRoles() {
		return roleService.getAllRoles();
	}

	// USER RELATED

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public GenericApiResponse createUser(@RequestBody SystemUserDto systemUserDto) {
		return userService.save(systemUserDto);
	}

}
