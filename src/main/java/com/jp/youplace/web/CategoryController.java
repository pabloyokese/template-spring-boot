package com.jp.youplace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.youplace.domain.Category;
import com.jp.youplace.service.ICategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;
	
	@ModelAttribute("category")
	public Category createCategory(){
		return new Category();
	}
	
	@RequestMapping("/")
	public String category(Model model){
		List<Category> categories = categoryService.findAll();
		model.addAttribute("current","category");
		model.addAttribute("categories",categories);
		return "category/list";
	}
	
	@RequestMapping("/{id}")
	public String categoryDetail(Model model, @PathVariable long id) {
		Category category = categoryService.findOne(id);
		model.addAttribute("category", category);
		model.addAttribute("current","category");
		return "category/detail";
	}
	
	@RequestMapping(value="/process-form")
	public String goForm(Model model){
		model.addAttribute("current","category");
		return "category/form";
	}
	
	@RequestMapping(value="/process-form",method=RequestMethod.POST)
	public String processForm(Model model,@ModelAttribute("category") Category category){
		model.addAttribute("current","category");
		categoryService.save(category);
		return "redirect:/category/process-form?success=true";
	}
	
	@RequestMapping("/update/{id}")
	public String register(Model model,@PathVariable long id){
		Category category = categoryService.findOne(id);
		model.addAttribute("category",category);
		model.addAttribute("current","category");
		return "category/form";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String doDelete(Model model,@PathVariable long id){
		categoryService.deleteById(id);
		model.addAttribute("current","category");
		return "redirect:/category/?deletesuccess=true";
	}
}
