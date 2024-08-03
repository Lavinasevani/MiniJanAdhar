package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/mainPage")
	public String userMainPage() {
		System.out.println("UserMainPage fired ...");
		return "user/MainPage";
	}
}
