package com.scm.services;

import java.util.Collection;
import java.util.Optional;

import com.scm.entities.Address;
import com.scm.entities.TestFamily;
import java.util.*;
public interface AddressService {
    Address saveAddress(Address address);
    Optional<Address> findById(Long id);
 
    
}
