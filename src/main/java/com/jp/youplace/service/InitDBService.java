package com.jp.youplace.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Role;
import com.jp.youplace.domain.RoleRepository;
import com.jp.youplace.domain.UserRepository;
import com.jp.youplace.domain.User;

@Service
public class InitDBService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	
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
	}
}
