package com.jp.youplace.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/user")
public class UserController {
	
	public String listUsers(){
		
		return "list";
	}
	
}
