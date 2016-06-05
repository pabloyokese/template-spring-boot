package com.jp.youplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.User;
import com.jp.youplace.domain.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	public void save(User user) {
		//user.setEnabled(true);
		// TODO: check it later, there is something weird
		if (user.getId() == 0) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
		} else {
			// the password will be always null
			if (user.getPassword() == null) {
				User userToGetPassword = findOne(user.getId());
				user.setPassword(userToGetPassword.getPassword());
			} else {
				// if the password is not null it means the user really want to
				// change his password
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword(encoder.encode(user.getPassword()));
			}

		}
		userRepository.save(user);
	}

	public Long count() {
		return userRepository.count();
	}

	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public void deleteById(Long id){
		userRepository.deleteById(id);
	}
}
