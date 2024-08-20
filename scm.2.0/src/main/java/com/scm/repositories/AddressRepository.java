package com.scm.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.Address;
import com.scm.entities.MemberInfo;
import com.scm.entities.TestFamily;
import com.scm.entities.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByTestFamily (TestFamily testFamily);


}

