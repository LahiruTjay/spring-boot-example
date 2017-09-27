package com.retail.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.pos.constant.CommonConstants;
import com.retail.pos.dto.request.RoleAuthorityDto;
import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Authority;
import com.retail.pos.entity.Role;
import com.retail.pos.entity.RoleAuthority;
import com.retail.pos.mapper.toEntity.DtoToEntityUser;
import com.retail.pos.repository.RoleAuthorityRepository;
import com.retail.pos.service.RoleAuthorityService;
import com.retail.pos.service.RoleService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	@Autowired
	RoleAuthorityRepository roleAuthorityRepository;

	@Autowired
	RoleService roleService;

	@Override
	@Transactional
	public GenericApiResponse saveRoleAuthorities(RoleAuthorityDto roleAuthorityDto) {

		try {

			Role existingRole = roleService.findRoleByName(roleAuthorityDto.getRoleName());

			if (existingRole != null) {
				Role role = DtoToEntityUser.getRole(roleAuthorityDto);

				roleAuthorityDto.getAuthorityList().stream().forEach(authorityRoleDto -> {

					Authority authority = DtoToEntityUser.getAuthority(authorityRoleDto);

					RoleAuthority roleAuthority = DtoToEntityUser.getRoleAuthority(role, authority);
					roleAuthorityRepository.save(roleAuthority);

				});

				return new GenericApiResponse(CommonConstants.STATUS_SUCCESSFULL, CommonConstants.ROLE_SUCCESSFULLY_CREATED);
				
			} else {
				return new GenericApiResponse(CommonConstants.STATUS_FAILED, CommonConstants.ROLE_ALREADY_AVAILABLE);
			}
		} catch (Exception e) {
			return new GenericApiResponse(CommonConstants.STATUS_FAILED, e.getMessage());
		}

	}
}
