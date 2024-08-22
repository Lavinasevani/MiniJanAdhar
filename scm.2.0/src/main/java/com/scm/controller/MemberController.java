package com.scm.controller;

import com.scm.forms.MemberInfoForm;
import com.scm.forms.MemberProfessionForm;
import com.scm.helper.Helper;
import com.scm.entities.MemberInfo;
import com.scm.entities.MemberProfession;
import com.scm.entities.User;
import com.scm.services.MemberService;
import com.scm.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;

    @RequestMapping("/user/fam/addLink")
    public String RegisterMember(Model model) {
        MemberInfoForm memberInfoForm = new MemberInfoForm();
        model.addAttribute("memberInfoForm", memberInfoForm);
        MemberProfessionForm memberProfessionForm = new MemberProfessionForm();
        model.addAttribute("memberProfessionForm", memberProfessionForm);
        System.out.println("Dummy New Enrollment Form Fired ..");
        return "user/createForm";
    }

    @PostMapping("/user/fam/add")
    public ResponseEntity<Map<String, Object>> processRegisterMember(
            @Valid @ModelAttribute("memberInfoForm") MemberInfoForm memberInfoForm,
            BindingResult infoBindingResult,
            @Valid @ModelAttribute("memberProfessionForm") MemberProfessionForm memberProfessionForm,
            BindingResult professionBindingResult,
            HttpSession session , Authentication authentication ) {
    	
    	String userName = Helper.getEmailOfLoggedInUser(authentication);
    	User user = userService.getUserByEmail(userName);

        // Check for validation errors
        if (infoBindingResult.hasErrors() || professionBindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                Map.of("success", false, "message", "Validation errors occurred")
            );
        }

        // Create and save MemberInfo
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setName(memberInfoForm.getName());
        memberInfo.setfName(memberInfoForm.getfName());
        memberInfo.setmName(memberInfoForm.getmName());
        memberInfo.setDob(memberInfoForm.getDob());
        memberInfo.setGender(memberInfoForm.getGender());
        memberInfo.setmAdhar(memberInfoForm.getmAdhar());
     // Set the createdBy field
        memberInfo.setUser(user);

        memberInfo = memberService.saveMemberInfo(memberInfo); // Save and get the saved entity

        // Create and save MemberProfession
        MemberProfession memberProfession = new MemberProfession();
        memberProfession.setEducation(memberProfessionForm.getEducation());
        memberProfession.setOccupation(memberProfessionForm.getOccupation());
        memberProfession.setResident(memberProfessionForm.getResident());
        memberProfession.setReligion(memberProfessionForm.getReligion());
        memberProfession.setCategory(memberProfessionForm.getCategory());
        memberProfession.setMobileNumber(memberProfessionForm.getMobileNumber());
       
        memberService.saveMemberProfession(memberProfession);

        // Prepare response with the memberId and other details
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("memberId", memberInfo.getId()); // Include the memberId in the response
        response.put("name", memberInfo.getName());
        response.put("age", calculateAge(memberInfo.getDob())); // Calculate age based on DOB
        response.put("gender", memberInfo.getGender());
        response.put("relation", "Self");
        response.put("isHof", memberInfo.getGender().equals("female") && calculateAge(memberInfo.getDob()) > 18);

        return ResponseEntity.ok(response);
    }

    private int calculateAge(String dob) {
        // Ensure the date format is YYYY-MM-DD
        if (dob == null || dob.isEmpty()) return 0;

        String[] parts = dob.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Java months are 0-based
        int day = Integer.parseInt(parts[2]);

        java.util.Calendar birthDate = java.util.Calendar.getInstance();
        birthDate.set(year, month, day);

        java.util.Calendar today = java.util.Calendar.getInstance();
        int age = today.get(java.util.Calendar.YEAR) - birthDate.get(java.util.Calendar.YEAR);

        // Adjust age if the birthday hasn't occurred yet this year
        if (today.get(java.util.Calendar.MONTH) < birthDate.get(java.util.Calendar.MONTH) ||
            (today.get(java.util.Calendar.MONTH) == birthDate.get(java.util.Calendar.MONTH) &&
             today.get(java.util.Calendar.DAY_OF_MONTH) < birthDate.get(java.util.Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }
}
