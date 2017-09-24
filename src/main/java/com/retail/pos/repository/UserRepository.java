package com.retail.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.pos.entity.SystemUser;

public interface UserRepository extends JpaRepository<SystemUser, String> {

	SystemUser findByUsernameIgnoreCase(String username);

	SystemUser findByUsername(String username);

	SystemUser findByNicNo(String nic);
}
