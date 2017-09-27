package com.retail.pos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.pos.entity.Member;
import com.retail.pos.repository.MemberRepository;
import com.retail.pos.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Override
	@Transactional
	public void saveMember() {

		Member member = new Member();
		member.setName("Lahiru");
		member.setEmail("email");

		memberRepository.save(member);

		//int i = 1 / 0;

		Member member1 = new Member();
		member1.setName("Lahiru");
		member1.setEmail("email");

		memberRepository.save(member1);

	}

}
