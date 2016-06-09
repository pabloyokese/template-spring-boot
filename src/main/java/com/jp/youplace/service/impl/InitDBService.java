package com.jp.youplace.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Category;
import com.jp.youplace.domain.Item;
import com.jp.youplace.domain.ItemRepository;
import com.jp.youplace.domain.Role;
import com.jp.youplace.domain.RoleRepository;
import com.jp.youplace.domain.User;
import com.jp.youplace.domain.UserRepository;
import com.jp.youplace.service.ICategoryService;
import com.jp.youplace.service.IItemService;

@Service
public class InitDBService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	IItemService itemService;
	
	@Autowired
	ICategoryService categoryService;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setUserName("admin");
		userAdmin.setEmail("jpo_54@hotmail.com");
		userAdmin.setAge(30);
		userAdmin.setGender("M");
		userAdmin.setEnabled(true);
		userAdmin.setFirstName("Juan Pablo");
		userAdmin.setLastName("oquendo");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		

		Category categoryParent = new Category();
		categoryParent.setName("Car");
		categoryService.save(categoryParent);
		
		Category categoryChild = new Category();
		categoryChild.setName("Houses");
		categoryService.save(categoryChild);
		
		Category categoryChild2 = new Category();
		categoryChild2.setName("Electronics");
		categoryService.save(categoryChild2);
		
		Item item = new Item();
		item.setName("Water bottle");
		item.setDescription("this is the description for this item");
		item.setPrice(new BigDecimal(10.3));
		item.setStock(10);
		item.setUser(userAdmin);
		item.setCategory(categoryChild2);
		itemService.save(item);
		
		
			
		
	}
}
