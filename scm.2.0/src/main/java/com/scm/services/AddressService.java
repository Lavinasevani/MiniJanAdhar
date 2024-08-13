package com.scm.services;

import java.util.Optional;

import com.scm.entities.Address;

public interface AddressService {
    Address saveAddress(Address address);
    Optional<Address> findById(Long id);
}
