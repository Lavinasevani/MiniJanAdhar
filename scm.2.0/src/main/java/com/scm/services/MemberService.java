package com.scm.services;

import com.scm.entities.MemberInfo;
import com.scm.entities.MemberProfession;
import com.scm.helper.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    MemberInfo saveMemberInfo(MemberInfo memberInfo);
    
    Optional<MemberInfo> getMemberInfoById(Long id);

    Optional<MemberInfo> updateMemberInfo(MemberInfo memberInfo) throws ResourceNotFoundException;

    void deleteMemberInfo(Long id) throws ResourceNotFoundException;

    List<MemberInfo> getAllMemberInfo();

    MemberProfession saveMemberProfession(MemberProfession memberProfession);

    Optional<MemberProfession> getMemberProfessionById(Long id);

    Optional<MemberProfession> updateMemberProfession(MemberProfession memberProfession) throws ResourceNotFoundException;

    void deleteMemberProfession(Long id) throws ResourceNotFoundException;

    List<MemberProfession> getAllMemberProfession();
}
