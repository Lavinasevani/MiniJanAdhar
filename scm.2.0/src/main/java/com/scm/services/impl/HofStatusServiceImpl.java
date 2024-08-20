//package com.scm.services.impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.scm.entities.HofStatus;
//import com.scm.repositories.HofStatusRepository;
//import com.scm.services.HofStatusService;
//
//@Service
//public class HofStatusServiceImpl implements HofStatusService {
//
//    @Autowired
//    private HofStatusRepository hofStatusRepository;
//
//    @Override
//    public boolean updateHofStatus(Long memberId, String relation) {
//        try {
//            HofStatus hofStatus = new HofStatus();
//            hofStatus.setMemberId(memberId);
//            hofStatus.setRelation(relation);
//
//            hofStatusRepository.save(hofStatus);
//            return true;
//        } catch (Exception e) {
//            // Handle exceptions accordingly
//            return false;
//        }
//    }
//}
