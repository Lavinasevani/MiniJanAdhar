package com.scm.services.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.TestFamily;
import com.scm.repositories.TestFamilyRepository;
import com.scm.services.TestFamilyService;

import java.util.List;

@Service
public class TestFamilyServiceImpl implements TestFamilyService {

    @Autowired
    private TestFamilyRepository testFamilyRepository;

    @Override
    public void saveFamilyMembers(List<TestFamily> familyMembers) {
        // Assuming each family group has a unique familyId, here you can set the familyId.
        // Generate or retrieve the family ID logic should be here.
        Long familyId = generateFamilyId(); 

        for (TestFamily member : familyMembers) {
            member.setFamilyId(familyId);
            testFamilyRepository.save(member);
        }
    }

    private Long generateFamilyId() {
        // Custom logic to generate a family ID, could be based on your requirement.
        // For simplicity, using current timestamp.
        return System.currentTimeMillis();
    }
    public Long getCurrentFamilyId() {
        // Retrieve the most recently saved family ID
        TestFamily latestFamily = testFamilyRepository.findTopByOrderByFamilyIdDesc();
        return latestFamily != null ? latestFamily.getFamilyId() : null;
    }
}

