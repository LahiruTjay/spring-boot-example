package com.retail.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.pos.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String roleName);

}