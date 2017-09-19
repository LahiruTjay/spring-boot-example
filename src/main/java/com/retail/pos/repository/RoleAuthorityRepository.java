package com.retail.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.pos.entity.Role;
import com.retail.pos.entity.RoleAuthority;

public interface RoleAuthorityRepository extends JpaRepository<RoleAuthority, Integer> {

	List<RoleAuthority> findAllByRole(Role role);
}
