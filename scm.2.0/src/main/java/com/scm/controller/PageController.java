package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForms;
import com.scm.helper.Message;
import com.scm.helper.messageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {
	@Autowired
	private UserService userService;
	
//	Dummy page Controller
	@RequestMapping("/home")
	public String home() {
		System.out.println("Dummy home page fired");
		return "index";
	}
	@RequestMapping("/loginRegister")
	public String login(Model model) {
		UserForms userForms = new UserForms();
		model.addAttribute("userForms",userForms);
		System.out.println("Dummy Register page fired");
		return "/loginRegister";
	}
	@RequestMapping("/login")
	public String loginpage() {
		System.out.println("Dummy Login page fired");
		return "/login";
	}
	@RequestMapping("/user/createJanPage")
	public String createJanpage() {
		System.out.println("Dummy createJanPage fired");
		return "/user/createForm";
	}
	@RequestMapping("/user/JanCard")
	public String cardJanpage() {
		System.out.println("Dummy address page fired");
		return "/user/address";
	}
	@RequestMapping("/user/JanCardd")
	public String cardJanpagee() {
		System.out.println("Dummy Payment page fired");
		return "/user/pay";
	}
	@RequestMapping("/user/confirm-janCard")
	public String cardJan() {
		System.out.println(" Dummy confirm-janCard page fired");
		return "/user/JanCard";
	}
	@RequestMapping("/user/updateJanPage")
	public String cardUJan() {
		System.out.println("Dummy updateJanPage page fired");
		return "/user/updateForm";
	}
	@RequestMapping("/user/getJanPage")
	public String cardGJan() {
		System.out.println("Dummy getJanPage page fired");
		return "/user/getForm";
	}
	
	
//	Original Page Controller
	
	
	@RequestMapping(value="/do-register" , method=RequestMethod.POST)
	public String processRegister(@Valid @ModelAttribute UserForms userForms , BindingResult rBindingResult ,HttpSession session) {
        // Log form data for debugging
        System.out.println("Real Registration Form data coming..");
        System.out.println(userForms);
        if(rBindingResult.hasErrors()) {
        	System.out.println("error ancountered .");
        	return "loginRegister";
        }
        // Convert form data to a User entity
        User user = new User();
        user.setName(userForms.getName());
        user.setEmail(userForms.getEmail());
        user.setPassword(userForms.getPassword());
        user.setAdhar(userForms.getAdhar());
        user.setDob(userForms.getDob()); 

        // Save the user to the database
        userService.saveUser(user);
        
        //message handler
        Message mess = Message.builder()
.content("Registration Successfully !!").type(messageType.green).build();
        session.setAttribute("message",mess);
        
        // Redirect to the login registration page
        return "redirect:/loginRegister";
    }
	
	    @GetMapping("/user/mainPage")
	    public String mainPage() {
	        return "/user/MainPage"; 
	    }

	@RequestMapping(value="/do-login" , method=RequestMethod.POST)
	public String processLogin() {
		System.out.println("Data coming from login");
		return "redirect:/login";
	}
}
