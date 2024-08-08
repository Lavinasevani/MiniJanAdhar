package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scm.entities.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
