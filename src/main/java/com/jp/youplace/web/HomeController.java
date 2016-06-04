package com.jp.youplace.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.youplace.service.UserService;

@Controller
public class HomeController{
	
	@Autowired
	UserService userService;
	
	/**
	 * All people can see this page
	 * this is the place to put all welcome information
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/dashboard")
	public String showDashBoard(){
		return "dashboard";
	}
	
}
