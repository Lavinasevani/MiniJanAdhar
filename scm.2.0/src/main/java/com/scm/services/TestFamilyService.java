package com.scm.services;




import java.util.List;


import com.scm.entities.TestFamily;

public interface TestFamilyService {
    void saveFamilyMembers(List<TestFamily> familyMembers);
    public Long getCurrentFamilyId();
    public Long getCurrentEnrollId();
	TestFamily getTestFamilyById(Long familyId);
	List<TestFamily> getMembersByFamilyId(Long familyId);


}

