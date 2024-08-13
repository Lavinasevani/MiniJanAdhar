package com.scm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.scm.entities.MemberInfo;
import com.scm.entities.User;
@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
	//CUSTOM FINDER METHOD 
	List<MemberInfo> findByUser (User user);
	
	
	
//	Custom QUERY METHOD 
//	@Query("SELECT m FROM MemberInfo WHERE m.user.id = :userid")
//	List<MemberInfo> findByUser (@Param("userId") String userId);
}
