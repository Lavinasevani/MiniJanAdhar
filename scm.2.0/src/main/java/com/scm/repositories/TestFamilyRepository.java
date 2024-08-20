package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scm.entities.TestFamily;
import java.util.*;

@Repository
public interface TestFamilyRepository extends JpaRepository<TestFamily, Long> {
    TestFamily findTopByOrderByIdDesc(); // Use 'Id' to match the primary key
    List<TestFamily> findByFamilyId(Long familyId);

}
