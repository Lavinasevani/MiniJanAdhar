package com.scm.services.impl;

import com.scm.entities.MemberInfo;
import com.scm.entities.MemberProfession;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.MemberInfoRepository;
import com.scm.repositories.MemberProfessionRepository;
import com.scm.services.MemberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Autowired
    private MemberProfessionRepository memberProfessionRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional
    public MemberInfo saveMemberInfo(MemberInfo memberInfo) {
        logger.info("Saving MemberInfo: {}", memberInfo);
        return memberInfoRepository.save(memberInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MemberInfo> getMemberInfoById(Long id) {
        return memberInfoRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<MemberInfo> updateMemberInfo(MemberInfo memberInfo) throws ResourceNotFoundException {
        MemberInfo existingMemberInfo = memberInfoRepository.findById(memberInfo.getId())
            .orElseThrow(() -> new ResourceNotFoundException("MemberInfo Not Found"));
        
        existingMemberInfo.setName(memberInfo.getName());
        existingMemberInfo.setfName(memberInfo.getfName());
        existingMemberInfo.setmName(memberInfo.getmName());
        existingMemberInfo.setDob(memberInfo.getDob());
        existingMemberInfo.setGender(memberInfo.getGender());
        existingMemberInfo.setmAdhar(memberInfo.getmAdhar());

        return Optional.of(memberInfoRepository.save(existingMemberInfo));
    }

    @Override
    @Transactional
    public void deleteMemberInfo(Long id) throws ResourceNotFoundException {
        MemberInfo existingMemberInfo = memberInfoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("MemberInfo Not Found"));
        
        memberInfoRepository.delete(existingMemberInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoRepository.findAll();
    }

    @Override
    @Transactional
    public MemberProfession saveMemberProfession(MemberProfession memberProfession) {
        logger.info("Saving MemberProfession: {}", memberProfession);
        return memberProfessionRepository.save(memberProfession);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MemberProfession> getMemberProfessionById(Long id) {
        return memberProfessionRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<MemberProfession> updateMemberProfession(MemberProfession memberProfession) throws ResourceNotFoundException {
        MemberProfession existingMemberProfession = memberProfessionRepository.findById(memberProfession.getId())
            .orElseThrow(() -> new ResourceNotFoundException("MemberProfession Not Found"));
        
        existingMemberProfession.setEducation(memberProfession.getEducation());
        existingMemberProfession.setOccupation(memberProfession.getOccupation());
        existingMemberProfession.setResident(memberProfession.getResident());
        existingMemberProfession.setReligion(memberProfession.getReligion());
        existingMemberProfession.setCategory(memberProfession.getCategory());
        existingMemberProfession.setMobileNumber(memberProfession.getMobileNumber());

        return Optional.of(memberProfessionRepository.save(existingMemberProfession));
    }

    @Override
    @Transactional
    public void deleteMemberProfession(Long id) throws ResourceNotFoundException {
        MemberProfession existingMemberProfession = memberProfessionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("MemberProfession Not Found"));
        
        memberProfessionRepository.delete(existingMemberProfession);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberProfession> getAllMemberProfession() {
        return memberProfessionRepository.findAll();
    }
}
