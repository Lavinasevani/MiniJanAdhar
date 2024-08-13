package com.scm.services;




import java.util.List;

import com.scm.entities.TestFamily;

public interface TestFamilyService {
    void saveFamilyMembers(List<TestFamily> familyMembers);
}

