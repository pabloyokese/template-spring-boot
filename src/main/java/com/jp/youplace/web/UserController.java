package com.jp.youplace.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jp.youplace.domain.Role;
import com.jp.youplace.domain.User;
import com.jp.youplace.service.IRoleService;
import com.jp.youplace.service.IUserService;
import com.jp.youplace.service.impl.RoleService;
import com.jp.youplace.service.impl.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleService roleService;

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

	@RequestMapping("/process-form")
	public String registerUser(Model model) {
		model.addAttribute("current","user");
		List<Role> roles = roleService.findAll();
		model.addAttribute("allRoles",roles);
		return "user/form";
	}
	
	@RequestMapping(value="/process-form", method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user,BindingResult result, RedirectAttributes redirectAttributes,Model model){
		model.addAttribute("current","user");
		List<Role> roles = roleService.findAll();
		model.addAttribute("allRoles",roles);
		if(result.hasErrors()){
			return "user/form";
		}
		userService.save(user);
		redirectAttributes.addFlashAttribute("success",true);
		return "redirect:/user/process-form";
	}
	
	@RequestMapping("/update/{id}")
	public String registerUser(Model model,@PathVariable long id){
		User user = userService.findOne(id);
		user.setPassword(null);
		List<Role> roles = roleService.findAll();
		model.addAttribute("allRoles",roles);
		model.addAttribute("user",user);
		model.addAttribute("current","user");
		return "user/form";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String doDelete(Model model,@PathVariable long id){
		userService.deleteById(id);
		model.addAttribute("current","user");
		return "redirect:/user/?deletesuccess=true";
	}
	
	@RequestMapping("/asign-role/{id}")
	public String asignRoles(Model model,@PathVariable long id){
		User user = userService.findOne(id);
		List<Role> roles = roleService.findAll();
		List<Role> userRoles = user.getRoles();		
		FormResult form = new FormResult();
		form.setRoles(userRoles);
		
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		model.addAttribute("form",form);
		return "user/asign-role";
	}
	
	
	
	@ModelAttribute("form")
	public FormResult constructForm(){
		return new FormResult();
	}
	@RequestMapping(value="/asign-role", method=RequestMethod.POST)
	public String doAsignRoles(Model model,@ModelAttribute("form") FormResult form,@RequestParam long userId){
		User user = userService.findOne(userId);
		user.setRoles(form.getRoles());
		userService.save(user);
		return "redirect:/user/asign-role/"+userId+"?addrolesuccess=true"; 
	}
	
	class FormResult{
		private List<Role> roles;
		public List<Role> getRoles() {
			return roles;
		}
		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}
	}
	
}
