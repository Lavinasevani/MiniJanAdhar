package com.scm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/mainPage")
    public String userMainPage(Model model, Authentication authentication) {
    	
    	String email = Helper.getEmailOfLoggedInUser(authentication);
        if (authentication != null) {
            System.out.println("User logged in:"+email);
        } else {
        	System.out.println("not found");
        }
        
        
       User user =  userService.getUserByEmail(email);
        user.getEmail();
        user.getId();
        user.getName();
        model.addAttribute("LoggedInUser", user);

        
        return "user/MainPage";
    }
}
