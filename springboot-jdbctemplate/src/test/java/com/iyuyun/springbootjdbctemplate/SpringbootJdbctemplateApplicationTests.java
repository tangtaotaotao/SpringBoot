package com.iyuyun.springbootjdbctemplate;

import com.iyuyun.springbootjdbctemplate.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbctemplateApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setUp(){
		userService.deleteAllUsers();
	}

	@Test
	public void testA() {
		userService.create("A",1);
		userService.create("AA",11);
		userService.create("AAA",111);

		Assert.assertEquals(3,userService.getAllUsers().intValue());

		userService.deleteByName("AA");

		Assert.assertEquals(2,userService.getAllUsers().intValue());
	}


}
