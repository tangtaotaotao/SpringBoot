package com.iyuyun.springbootspringdatajpa;

import com.iyuyun.springbootspringdatajpa.dao.UserRepository;
import com.iyuyun.springbootspringdatajpa.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSpringdatajpaApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		userRepository.save(new User("A",10));
		userRepository.save(new User("B",20));
		userRepository.save(new User("C",30));

		Assert.assertEquals(3,userRepository.findAll().size());

		Assert.assertEquals(20,userRepository.findByUsername("B").getAge());

		Assert.assertEquals("C",userRepository.findByUsernameAndAge("C",30).getUsername());

		Assert.assertEquals(10,userRepository.findUser("A").getAge());
	}

}
