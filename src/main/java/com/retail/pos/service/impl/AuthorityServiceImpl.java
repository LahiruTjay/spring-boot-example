package com.retail.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.pos.constant.CommonConstants;
import com.retail.pos.dto.request.AuthorityDto;
import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Authority;
import com.retail.pos.mapper.toDto.EntityToDtoUser;
import com.retail.pos.repository.AuthorityRepository;
import com.retail.pos.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	@Transactional
	public GenericApiResponse getAllAuthorities() {
		
		try {
			
			List<AuthorityDto> authotiyList = authorityRepository.findAll().stream().map(EntityToDtoUser::getAuthorityDto).collect(Collectors.toList());
			
			return new GenericApiResponse(CommonConstants.STATUS_SUCCESSFULL, CommonConstants.STATUS_SUCCESSFULL, authotiyList);
			
		} catch (Exception e) {
			return new GenericApiResponse(CommonConstants.STATUS_FAILED, e.getMessage());
		}
	}

	@Override
	@Transactional
	public void saveAuthority(Authority authority) {
		authorityRepository.save(authority);
	}

}
