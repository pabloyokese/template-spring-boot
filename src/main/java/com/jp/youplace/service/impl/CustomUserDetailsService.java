package com.jp.youplace.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Role;
import com.jp.youplace.domain.RoleRepository;
import com.jp.youplace.domain.User;
import com.jp.youplace.domain.UserRepository;
import com.jp.youplace.security.CustomUserDetails;
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	
	UserRepository userRepository;
	RoleRepository roleRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {	
		User user = userRepository.findByUserName(userName);
		if (user.equals(null)) {
			throw new UsernameNotFoundException("No user present with username :" + user.getUserName());
		}else{
			//List<String> roles = roleRepository.findRolNameByUserName(userName);
			List<Role> roles = user.getRoles();
			List<String> stringRoles = new ArrayList<>();
			for (Role role : roles) {
				stringRoles.add(role.getName());
			}
			return new CustomUserDetails(user, stringRoles);
		}		
	}

}
