package com.jp.youplace.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jp.youplace.YourPlaceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YourPlaceApplication.class)
@WebAppConfiguration
public class YourPlaceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
