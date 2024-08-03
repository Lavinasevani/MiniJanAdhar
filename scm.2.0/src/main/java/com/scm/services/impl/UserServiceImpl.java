package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User existingUser = userRepo.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAdhar(user.getAdhar());
        existingUser.setDob(user.getDob());
        User updatedUser = userRepo.save(existingUser);

        return Optional.ofNullable(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
    	User existingUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
       userRepo.delete(existingUser);
    }

    @Override
    public boolean isUserExist(Long userId) {
        // Implementation needed
        User existingUser = userRepo.findById(userId).orElse(null);
        return existingUser != null ? true : false;
    }

    @Override
    public boolean isUserExistByUserName(String email) {
    	User existingUser = userRepo.findByEmail(email).orElse(null);
        return existingUser != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        // Implementation needed
        return userRepo.findAll();
    }
}
