package com.scm.controller;

import com.scm.forms.MemberInfoForm;
import com.scm.forms.MemberProfessionForm;
import com.scm.helper.Message;
import com.scm.helper.messageType;
import com.scm.entities.MemberInfo;
import com.scm.entities.MemberProfession;
import com.scm.services.MemberService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/user/fam/addLink")
    public String RegisterMember(Model model) {
        MemberInfoForm memberInfoForm = new MemberInfoForm();
        model.addAttribute("memberInfoForm", memberInfoForm);
        MemberProfessionForm memberProfessionForm = new MemberProfessionForm();
        model.addAttribute("memberProfessionForm", memberProfessionForm);
        System.out.println("Dummy New Enrollment Form Fired ..");
        return "/user/createForm";
    }

    @PostMapping("/user/fam/add")
    public ResponseEntity<?> processRegisterMember(
            @Valid @ModelAttribute("memberInfoForm") MemberInfoForm memberInfoForm,
            BindingResult infoBindingResult,
            @Valid @ModelAttribute("memberProfessionForm") MemberProfessionForm memberProfessionForm,
            BindingResult professionBindingResult,
            HttpSession session) {

        if (infoBindingResult.hasErrors() || professionBindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                Map.of("success", false, "message", "Validation errors occurred")
            );
        }

        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setName(memberInfoForm.getName());
        memberInfo.setfName(memberInfoForm.getfName());
        memberInfo.setmName(memberInfoForm.getmName());
        memberInfo.setDob(memberInfoForm.getDob());
        memberInfo.setGender(memberInfoForm.getGender());
        memberInfo.setmAdhar(memberInfoForm.getmAdhar());

        MemberProfession memberProfession = new MemberProfession();
        memberProfession.setEducation(memberProfessionForm.getEducation());
        memberProfession.setOccupation(memberProfessionForm.getOccupation());
        memberProfession.setResident(memberProfessionForm.getResident());
        memberProfession.setReligion(memberProfessionForm.getReligion());
        memberProfession.setCategory(memberProfessionForm.getCategory());
        memberProfession.setMobileNumber(memberProfessionForm.getMobileNumber());

        memberService.saveMemberInfo(memberInfo);
        memberService.saveMemberProfession(memberProfession);

        Message mess = Message.builder()
                .content("Member Saved !!")
                .type(messageType.blue)
                .build();
        session.setAttribute("message", mess);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "name", memberInfo.getName(),
                "age", calculateAge(memberInfo.getDob()), // Ensure this matches your form data
                "gender", memberInfo.getGender(),
                "relation", "Self",
                "isHof", memberInfo.getGender().equals("female") && calculateAge(memberInfo.getDob()) > 18
        ));
    }


    private int calculateAge(String dob) {
        // Add your age calculation logic here
        // This is a placeholder
        if (dob == null || dob.isEmpty()) return 0;
        String[] parts = dob.split("-");
        int year = Integer.parseInt(parts[2]);
        int month = Integer.parseInt(parts[1]) - 1;
        int day = Integer.parseInt(parts[0]);
        java.util.Calendar birthDate = java.util.Calendar.getInstance();
        birthDate.set(year, month, day);
        int age = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - birthDate.get(java.util.Calendar.YEAR);
        if (java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) < birthDate.get(java.util.Calendar.MONTH) ||
            (java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) == birthDate.get(java.util.Calendar.MONTH) &&
            java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) < birthDate.get(java.util.Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }
}
