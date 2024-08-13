package com.scm.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.TestFamily;

@Repository
public interface TestFamilyRepository extends JpaRepository<TestFamily, Long> {
	TestFamily findTopByOrderByFamilyIdDesc();
}
