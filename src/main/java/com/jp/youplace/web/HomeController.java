package com.jp.youplace.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.youplace.service.UserService;

@Controller
public class HomeController{
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String showHome(){
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/hello")
	public String showHello(){
		return "hello";
	}
	
}
