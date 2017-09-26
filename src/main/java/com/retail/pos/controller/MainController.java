package com.retail.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.service.impl.MemberServiceImpl;

@RestController
public class MainController {

	@Autowired
	MemberServiceImpl memberRepo;

	@PreAuthorize("hasRole('ROLE_ONE')")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		
		memberRepo.saveMember();
		
		return "working";
	}

	@PreAuthorize("hasRole('ROLE_ONE')")
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ResponseEntity<?> authTest(@RequestParam("status") String status) {

		if (status.equals("ok")) {
			//Iterable<Member> membeList = memberRepo.findAll();
			return ResponseEntity.ok().body(new GenericApiResponse("", ""));
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
