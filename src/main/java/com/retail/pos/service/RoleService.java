package com.retail.pos.service;

import com.retail.pos.entity.Role;

public interface RoleService {

	public void createRole(Role role);

	public Role findRoleById(int roleId);

}
