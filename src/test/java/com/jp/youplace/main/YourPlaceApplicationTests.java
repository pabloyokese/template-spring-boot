package com.jp.youplace.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jp.youplace.YourPlaceApplication;
import com.jp.youplace.domain.User;
import com.jp.youplace.service.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YourPlaceApplication.class)
@WebAppConfiguration
public class YourPlaceApplicationTests {
	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setFirstName("Juan Pablo Oquendo");
		user.setLastName("Oquendo");
		user.setGender("M");
		user.setUser("pabloyokese");
		user.setPassword("123");
		user.setEmail("jpo_54@hotmail.com");
		userService.save(user);
		Assert.assertTrue(user.getId() != 0);
	}

}
