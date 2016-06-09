package com.jp.youplace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.youplace.domain.Role;
import com.jp.youplace.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	@ModelAttribute("role")
	public Role createRole(){
		return new Role();
	}
	
	@RequestMapping("/")
	public String role(Model model){
		List<Role> roles = roleService.findAll();
		model.addAttribute("current","role");
		model.addAttribute("roles",roles);
		return "role/list";
	}
	
	@RequestMapping("/{id}")
	public String userDetail(Model model, @PathVariable long id) {
		Role role = roleService.findOne(id);
		model.addAttribute("role", role);
		model.addAttribute("current","role");
		return "role/detail";
	}
	
	@RequestMapping(value="/process-form")
	public String goForm(Model model,@ModelAttribute("role") Role role){
		model.addAttribute("current","role");
		return "role/form";
	}
	
	@RequestMapping(value="/process-form",method=RequestMethod.POST)
	public String processForm(Model model,@ModelAttribute("role") Role role){
		model.addAttribute("current","role");
		roleService.save(role);
		return "redirect:/role/process-form?success=true";
	}
	
	@RequestMapping("/update/{id}")
	public String registerRole(Model model,@PathVariable long id){
		Role role = roleService.findOne(id);
		model.addAttribute("role",role);
		model.addAttribute("current","role");
		return "role/form";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String doDelete(Model model,@PathVariable long id){
		roleService.deleteById(id);
		model.addAttribute("current","role");
		return "redirect:/role/?deletesuccess=true";
	}
}
