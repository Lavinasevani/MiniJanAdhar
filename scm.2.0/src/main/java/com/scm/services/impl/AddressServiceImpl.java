package com.scm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.Address;
import com.scm.repositories.AddressRepository;
import com.scm.services.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }
    
    
}
