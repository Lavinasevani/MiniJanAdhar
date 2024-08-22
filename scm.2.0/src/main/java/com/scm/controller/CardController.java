package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.TestFamily;
import com.scm.entities.Address;
import com.scm.services.TestFamilyService;
import com.scm.services.AddressService;

import java.util.List;

@Controller
public class CardController {

    @Autowired
    private TestFamilyService testFamilyService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("/user/card")
    public String cardPage(Model model) {
        // Get the current family ID
        Long familyNumber = testFamilyService.getCurrentEnrollId();

        // Retrieve the list of members with the current family ID
        List<TestFamily> familyMembers = testFamilyService.getMembersByFamilyId(familyNumber);

        // Find the Head of Family (HoF) where hof_status is 'Yes'
        String hofName = familyMembers.stream()
                                      .filter(member -> "Yes".equals(member.getHofStatus()))
                                      .map(TestFamily::getMemberName)
                                      .findFirst()
                                      .orElse("Not Found");

        // Retrieve the address for the family
//        Address address = addressService.getAddressesByFamilyNumber(familyNumber)
//                                        .stream()
//                                        .findFirst()  // Since all family members share the same address, get the first one
//                                        .orElse(null);

        // Add the family ID, member list, HoF name, and address to the model
        model.addAttribute("familyNumber", familyNumber);
        model.addAttribute("familyMembers", familyMembers);
        model.addAttribute("hofName", hofName);
//        model.addAttribute("address", address);

        System.out.println("Card Generation fired with familyId: " + familyNumber);
        return "user/card";
    }
}
