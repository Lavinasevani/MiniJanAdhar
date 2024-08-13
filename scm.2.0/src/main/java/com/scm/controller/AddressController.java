package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.Address;
import com.scm.forms.AddressForm;
import com.scm.forms.MemberInfoForm;
import com.scm.forms.MemberProfessionForm;
import com.scm.services.AddressService;
import com.scm.services.FamilyService;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private FamilyService familyService;

    @RequestMapping("/user/address")
    public String showAddressForm(Model model) {
        AddressForm addressForm = new AddressForm();
        model.addAttribute("addressForm", addressForm);
        System.out.println("Dummy Address form Form Fired ..");
        return "/user/address";
    }
    
    @PostMapping("/user/JanCardd" )
    public ResponseEntity<?> submitAddress(@RequestBody AddressForm addressForm) {
        Long familyId = familyService.getCurrentFamilyId();
        Address address = new Address();
        address.setFamilyId(familyId);
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

