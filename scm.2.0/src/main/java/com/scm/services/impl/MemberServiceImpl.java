package com.scm.services.impl;

import com.scm.entities.MemberInfo;
import com.scm.entities.MemberProfession;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.MemberInfoRepository;
import com.scm.repositories.MemberProfessionRepository;
import com.scm.services.MemberService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Autowired
    private MemberProfessionRepository memberProfessionRepository;

    @Override
    public MemberInfo saveMemberInfo(MemberInfo memberInfo) {
        return memberInfoRepository.save(memberInfo);
    }

    @Override
    public Optional<MemberInfo> getMemberInfoById(Long id) {
        return memberInfoRepository.findById(id);
    }

    @Override
    public Optional<MemberInfo> updateMemberInfo(MemberInfo memberInfo) throws ResourceNotFoundException {
        if (!memberInfoRepository.existsById(memberInfo.getId())) {
            throw new ResourceNotFoundException("MemberInfo not found");
        }
        return Optional.of(memberInfoRepository.save(memberInfo));
    }

    @Override
    public void deleteMemberInfo(Long id) throws ResourceNotFoundException {
        if (!memberInfoRepository.existsById(id)) {
            throw new ResourceNotFoundException("MemberInfo not found");
        }
        memberInfoRepository.deleteById(id);
    }

    @Override
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoRepository.findAll();
    }

    @Override
    public MemberProfession saveMemberProfession(MemberProfession memberProfession) {
        return memberProfessionRepository.save(memberProfession);
    }

    @Override
    public Optional<MemberProfession> getMemberProfessionById(Long id) {
        return memberProfessionRepository.findById(id);
    }

    @Override
    public Optional<MemberProfession> updateMemberProfession(MemberProfession memberProfession) throws ResourceNotFoundException {
        if (!memberProfessionRepository.existsById(memberProfession.getId())) {
            throw new ResourceNotFoundException("MemberProfession not found");
        }
        return Optional.of(memberProfessionRepository.save(memberProfession));
    }

    @Override
    public void deleteMemberProfession(Long id) throws ResourceNotFoundException {
        if (!memberProfessionRepository.existsById(id)) {
            throw new ResourceNotFoundException("MemberProfession not found");
        }
        memberProfessionRepository.deleteById(id);
    }

    @Override
    public List<MemberProfession> getAllMemberProfession() {
        return memberProfessionRepository.findAll();
    }

    /////////////////////////////////////////
    @Override
    @Transactional
    public void saveMember(MemberInfo memberInfo, MemberProfession memberProfession) {
        // Save MemberInfo
        memberInfo = memberInfoRepository.save(memberInfo);

        // Set the reference to the saved MemberInfo
        memberProfession.setMemberInfo(memberInfo);

        // Save MemberProfession
        memberProfessionRepository.save(memberProfession);
    }
    
    
    
}
