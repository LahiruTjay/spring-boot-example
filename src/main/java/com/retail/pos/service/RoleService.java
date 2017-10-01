package com.retail.pos.service;

import com.retail.pos.dto.response.GenericApiResponse;
import com.retail.pos.entity.Role;

public interface RoleService {

	public GenericApiResponse getAllRoles();

	public void createRole(Role role);

	public Role findRoleById(int roleId);

	public Role findRoleByName(String roleName);

}
