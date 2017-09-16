package com.retail.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retail.pos.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>{

}
