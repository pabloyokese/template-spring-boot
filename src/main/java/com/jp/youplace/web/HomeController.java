package com.jp.youplace.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.youplace.service.IUserService;
import com.jp.youplace.service.impl.UserService;

@Controller
public class HomeController{
	
	@Autowired
	IUserService userService;
	
	/**
	 * All people can see this page
	 * this is the place to put all welcome information
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("current","index");
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin(Model model){
		model.addAttribute("current","login");
		return "login";
	}
	
	@RequestMapping("/dashboard")
	public String showDashBoard(Model model){
		model.addAttribute("current","dashboard");
		return "dashboard";
	}
	
}
