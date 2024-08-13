package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.entities.FamilyRegistrationRequest;
import com.scm.services.FamilyService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/fam")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("/hof/status")
    public ResponseEntity<Map<String, Object>> registerFamily(
            @RequestBody FamilyRegistrationRequest request) {
        try {
            Long familyId = familyService.registerFamily(
                    request.getMembers(),
                    request.getRelations(),
                    request.getHofStatuses()
            );

            return ResponseEntity.ok(Map.of("success", true, "familyId", familyId));
        } catch (Exception e) {
            // Log the error (optional)
            e.printStackTrace();

            // Return a meaningful error response
            return ResponseEntity.status(500).body(Map.of("success", false, "error", "Failed to register family."));
        }
    }
}
