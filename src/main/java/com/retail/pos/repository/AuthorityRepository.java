package com.retail.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.pos.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}