//package com.scm.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.scm.entities.Enroll;
//import com.scm.entities.MemberInfo;
//import com.scm.entities.TestFamily;
//import com.scm.repositories.EnrollRepository;
//import com.scm.repositories.TestFamilyRepository;
//
//import java.util.List;
//
//@Service
//public class FamilyService {
//
//    @Autowired
//    private EnrollRepository enrollRepository;
//    
//    @Autowired
//    private TestFamilyRepository testFamilyRepository;
//    
//    @Transactional
//    public Long registerFamily(List<MemberInfo> members, List<String> relations, List<Boolean> hofStatuses) {
//        Long enrollId = null;
//
//        for (int i = 0; i < members.size(); i++) {
//            Enroll enroll = new Enroll();
//            enroll.setMemberId(members.get(i).getId());
//            enroll.setRelationWithHof(relations.get(i));
//            enroll.setHofStatus(hofStatuses.get(i) ? "Yes" : "No");
//
//            Enroll savedEnroll = enrollRepository.save(enroll);
//
//            if (enrollId == null) {
//                enrollId = savedEnroll.getEnrollId(); // Keep the same enrollId for all family members
//            } else {
//                savedEnroll.setEnrollId(enrollId);
//                enrollRepository.save(savedEnroll);
//            }
//        }
//
//        return enrollId;
//    }
//
// // Method to get the current family ID (latest enrollId)
//    public Long getCurrentFamilyId() {
//        Enroll latestEnroll = enrollRepository.findTopByOrderByEnrollIdDesc();
//        return latestEnroll != null ? latestEnroll.getEnrollId() : null;
//    }
//
//    public TestFamily getTestFamilyById(Long familyId) {
//        return testFamilyRepository.findById(familyId).orElse(null);
//    }
//	
//}
//
