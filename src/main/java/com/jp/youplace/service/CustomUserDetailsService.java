package com.jp.youplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jp.youplace.domain.RoleRepository;
import com.jp.youplace.domain.User;
import com.jp.youplace.domain.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	
	UserRepository userRepository;
	RoleRepository roleRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		User user = userRepository.findByUserName();
		if (user.equals(null)) {
			throw new UsernameNotFoundException("No user present with username :" + user.getUserName());
		}else{
			List<String> roles = roleRepository.findRolNameByUserName();
			return new CustomUserDetails(user, roles);
		}		
	}

}
