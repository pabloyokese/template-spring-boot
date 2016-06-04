package com.jp.youplace.web;

import org.springframework.stereotype.Controller;

@Controller("/user")
public class UserController {
	
	public String listUsers(){
		
		return "list";
	}
	
}
