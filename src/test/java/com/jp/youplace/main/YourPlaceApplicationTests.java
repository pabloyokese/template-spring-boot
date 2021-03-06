package com.jp.youplace.main;

import com.jp.youplace.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jp.youplace.YourPlaceApplication;
import com.jp.youplace.domain.User;
import com.jp.youplace.service.impl.UserService;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YourPlaceApplication.class)
@WebAppConfiguration
public class YourPlaceApplicationTests {
	@Autowired
    IUserService userService;

	@Test
	public void createUser() {
		User user = setUpUser();
		userService.save(user);
		assertTrue(user.getId() != 0);
	}

	@Test
	public void updateUser() {
		User user = setUpUser();
		userService.save(user);
		String dataToUpdate= "pabloyokese54";
		user.setUserName(dataToUpdate);
		userService.save(user);
		Long userSaved = user.getId();
		User userFromDB = userService.findOne(userSaved);
		assertEquals(userFromDB.getUserName(), dataToUpdate);
	}

	public User setUpUser() {
		User user = new User();
		user.setFirstName("Juan Pablo Oquendo");
		user.setLastName("Oquendo");
		user.setGender("M");
		user.setUserName("pabloyokese");
		user.setPassword("123");
		user.setEmail("jpo_54@hotmail.com");
		return user;
	}

	@Test
	public void deleteUser() {
		User user = setUpUser();
		userService.save(user);
		userService.delete(user);

		long totalUsers = userService.count();
		assertEquals(totalUsers, 3);
	}
	
	@Test
	public void listUser(){
		List<User> users = userService.findAll();
		for (User user : users) {
			assertNotNull(user);
		}
		long totalUsers = userService.count();
		assertEquals(totalUsers, users.size());
	}

}
