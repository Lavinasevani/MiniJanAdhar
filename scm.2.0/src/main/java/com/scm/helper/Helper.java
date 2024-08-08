package com.scm.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {

    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public static String getEmailOfLoggedInUser(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            String clientId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
            OAuth2User oauth2User = oAuth2AuthenticationToken.getPrincipal();
            String username = "";

            if ("google".equalsIgnoreCase(clientId)) {
                // sign in with Google
                logger.info("Getting email from Google");
                if (oauth2User.getAttribute("email") != null) {
                    username = oauth2User.getAttribute("email").toString();
                } else {
                    logger.error("Email attribute not found for Google user");
                }
            }
            return username;
        } else {
            logger.info("Getting data from local database");
            return authentication.getName();
        }
    }
}
