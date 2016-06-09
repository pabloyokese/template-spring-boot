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
import com.jp.youplace.domain.Item;
import com.jp.youplace.domain.Role;
import com.jp.youplace.service.ICategoryService;
import com.jp.youplace.service.IItemService;
import com.jp.youplace.service.IRoleService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	IItemService itemService;
	
	@Autowired
	ICategoryService categoryService;
	
	@ModelAttribute("item")
	public Item createItem(){
		return new Item();
	}
	
	@RequestMapping("/")
	public String role(Model model){
		List<Item> items = itemService.findAll();
		model.addAttribute("current","item");
		model.addAttribute("items",items);
		return "item/list";
	}
	
	@RequestMapping("/{id}")
	public String userDetail(Model model, @PathVariable long id) {
		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		model.addAttribute("current","item");
		return "item/detail";
	}
	
	@RequestMapping(value="/process-form")
	public String goForm(Model model){
		List<Category> categories = categoryService.findAll();
		model.addAttribute("current","item");
		model.addAttribute("allCategories",categories);
		return "item/form";
	}
	
	@RequestMapping(value="/process-form",method=RequestMethod.POST)
	public String processForm(Model model,@ModelAttribute("item") Item item){
		model.addAttribute("current","item");
		itemService.save(item);
		return "redirect:/item/process-form?success=true";
	}
	
	@RequestMapping("/update/{id}")
	public String registerRole(Model model,@PathVariable long id){
		Item item = itemService.findOne(id);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("item",item);
		model.addAttribute("allCategories",categories);
		model.addAttribute("current","item");
		return "item/form";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String doDelete(Model model,@PathVariable long id){
		itemService.deleteById(id);
		model.addAttribute("current","item");
		return "redirect:/item/?deletesuccess=true";
	}
}
