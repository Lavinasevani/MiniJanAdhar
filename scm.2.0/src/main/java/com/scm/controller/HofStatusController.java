//package com.scm.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import com.scm.entities.MemberInfo;
//import com.scm.helper.Helper;
//import com.scm.services.HofStatusService;
//import com.scm.services.MemberService;
//
//@RestController
//@RequestMapping("/user/fam/hof")
//public class HofStatusController {
//
//    @Autowired
//    private HofStatusService hofStatusService;
//
//    @Autowired
//    private MemberService memberService;
//
//    @PostMapping("/statussses")
//    public String updateHofStatus(@RequestParam("memberId") String memberIdStr,
//                                   @RequestParam("relation") String relation,
//                                   Authentication authentication) {
//        Long memberId;
//        try {
//            memberId = Long.parseLong(memberIdStr);
//        } catch (NumberFormatException e) {
//            return "Invalid member ID.";
//        }
//
//        // Log received memberId for debugging
//        System.out.println("Received memberId: " + memberIdStr);
//
//        // Retrieve logged-in user's email (if needed)
//        String userName = Helper.getEmailOfLoggedInUser(authentication);
//
//        // Verify if the member exists
//        Optional<MemberInfo> memberInfo = memberService.getMemberInfoById(memberId);
//        if (!memberInfo.isPresent()) {
//            return "Member not found.";
//        }
//
//        // Update HofStatus
//        boolean success = hofStatusService.updateHofStatus(memberId, relation);
//        if (success) {
//            return "Head of Family status updated successfully!";
//        } else {
//            return "Failed to update Head of Family status.";
//        }
//    }
//}
