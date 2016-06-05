package com.jp.youplace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.youplace.domain.User;
import com.jp.youplace.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
		

	@RequestMapping("/")
	public String listUsers(Model model) {
		List<User> listUsers = userService.findAll();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("current","user");
		return "user/list";
	}

	@RequestMapping("/{id}")
	public String userDetail(Model model, @PathVariable long id) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("current","user");
		return "user/detail";
	}

	@RequestMapping("/register")
	public String registerUser(Model model) {
		model.addAttribute("current","user");
		return "user/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(Model model,@ModelAttribute("user") User user){
		model.addAttribute("current","user");
		userService.save(user);
		return "redirect:/user/register?success=true";
	}
	
	@RequestMapping("/update/{id}")
	public String registerUser(Model model,@PathVariable long id){
		User user = userService.findOne(id);
		user.setPassword(null);
		model.addAttribute("user",user);
		model.addAttribute("current","user");
		return "user/register";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String doDelete(Model model,@PathVariable long id){
		userService.deleteById(id);
		model.addAttribute("current","user");
		return "redirect:/user/?deletesuccess=true";
	}
	
}
