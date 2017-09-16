package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.entity.Member;
import com.retail.pos.repository.MemberRepository;

@RestController
public class MainController {

	@Autowired
	MemberRepository memberRepo;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Iterable<Member> getAllUsers() {
		return memberRepo.findAll();
	}
}
