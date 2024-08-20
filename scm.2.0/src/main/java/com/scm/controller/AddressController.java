package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import com.scm.entities.Address;
import com.scm.entities.TestFamily;
import com.scm.entities.User;
import com.scm.forms.AddressForm;
import com.scm.forms.MemberInfoForm;
import com.scm.forms.MemberProfessionForm;
import com.scm.helper.Helper;
import com.scm.services.AddressService;

import com.scm.services.TestFamilyService;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private TestFamilyService testFamilyService;

    @RequestMapping("/user/address")
    public String showAddressForm(Model model) {
        AddressForm addressForm = new AddressForm();
        model.addAttribute("addressForm", addressForm);
        System.out.println("Dummy Address form Form Fired ..");
        return "/user/address";
    }
    
    @PostMapping("/user/JanCardd" )
    public ResponseEntity<?> submitAddress(@RequestBody AddressForm addressForm ,Authentication authentication) {
    	
    	
    	Long familyId = testFamilyService.getCurrentFamilyId();

        if (familyId == null) {
        	System.out.println("Erorr to find fmaily id ");
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Family ID not found\"}");
        }

        System.out.println("Retrieved familyId: " + familyId);

        // Retrieve the TestFamily entity
        TestFamily testFamily = testFamilyService.getTestFamilyById(familyId);
        if (testFamily == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"TestFamily not found\"}");
        }
     
        Address address = new Address();
        address.setTestFamily(testFamily); 
        address.setAddressLine1(addressForm.getAddressLine1());
        address.setAddressLine2(addressForm.getAddressLine2());
        address.setHouseNo(addressForm.getHouseNo());
        address.setWardNo(addressForm.getWardNo());
        address.setBlock(addressForm.getBlock());
        address.setDistrict(addressForm.getDistrict());
        address.setCity(addressForm.getCity());
        address.setPinCode(addressForm.getPinCode());

        addressService.saveAddress(address);
        return ResponseEntity.ok().body("{\"success\": true}");
    }
}

