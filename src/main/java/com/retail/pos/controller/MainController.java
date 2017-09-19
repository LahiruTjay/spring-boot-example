package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.repository.MemberRepository;

@RestController
public class MainController {

	@Autowired
	MemberRepository memberRepo;
	
	@PreAuthorize ("hasRole('ROLE_TWO')")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "working";
	}
	
	@PreAuthorize ("hasRole('ROLE_ONE')")
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String authTest() {
		return "working";
	}
	
}
