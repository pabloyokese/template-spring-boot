package com.jp.youplace.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.youplace.domain.User;
import com.jp.youplace.service.UserService;

@Controller
public class HomeController{
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String showHome(){
		User user = new User(0,"name");
		userService.save(user);
		System.out.println("user saved");
		
		List<User> findAll = userService.findAll();
		for (User userItem : findAll) {
			System.out.println(userItem);
		}
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
