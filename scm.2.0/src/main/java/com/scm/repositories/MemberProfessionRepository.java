package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.MemberProfession;

public interface MemberProfessionRepository extends JpaRepository<MemberProfession, Long> {
	
}