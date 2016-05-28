package com.jp.youplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.User;
import com.jp.youplace.domain.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public User findOne(Long id){
		return userRepository.findOne(id);
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public Long count(){
		return userRepository.count();
	}
	
	public void delete(User user){
		userRepository.delete(user);
	}
}
