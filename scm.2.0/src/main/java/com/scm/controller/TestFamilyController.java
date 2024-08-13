package com.scm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scm.entities.TestFamily;
import com.scm.services.TestFamilyService;

import java.util.List;

@RestController
public class TestFamilyController {

    @Autowired
    private TestFamilyService testFamilyService;

    @PostMapping("/saveFamily")
    public String saveFamily(@RequestBody List<TestFamily> familyMembers) {
        testFamilyService.saveFamilyMembers(familyMembers);
        return "Family members saved successfully!";
    }
}
