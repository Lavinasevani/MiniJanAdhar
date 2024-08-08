package com.scm.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.entities.Provider;
import com.scm.entities.User;
import com.scm.repositories.UserRepo;

import java.util.concurrent.atomic.AtomicLong;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(OAuthenticationSuccessHandler.class);
    private static final AtomicLong counter = new AtomicLong();
    @Autowired
    private UserRepo userRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("Authentication successful for user: {}", authentication.getName());
        DefaultOAuth2User user = (DefaultOAuth2User)authentication.getPrincipal();
//        logger.info(user.getName());
//        user.getAttributes().forEach((key,value)->{
//        	logger.info( "{} => {}",key,value);
//        });
//        logger.info(user.getAuthorities().toString());
        
        String email = user.getAttribute("email").toString();
        String name = user.getAttribute("name").toString();
        String picture = user.getAttribute("picture").toString();
        
        User user1 = new User();
        user1.setEmail(email);
        user1.setName(name);
        user1.setAdhar("AUTO ADHAR");
        user1.setDob("AUTO DOB");
        user1.setPassword(picture);
        user1.setId(counter.incrementAndGet());
        user1.setProviderUserId(user.getName());
        user1.setProvider(Provider.GOOGLE);
        user1.setEnable(true);
        user1.setEmailverified(true);
        
       User user2 =  userRepo.findByEmail(email).orElse(null);
       if(user2 == null) {
    	   userRepo.save(user1);
    	   logger.info("User Saved" + email);       
    	}
        
        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/mainPage");
    }
}
