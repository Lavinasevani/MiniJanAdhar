package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.Enroll;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {

	Enroll findTopByOrderByEnrollIdDesc();
}
