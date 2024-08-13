package com.scm.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

