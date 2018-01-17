package com.iyuyun.springbootehcache;

import com.iyuyun.springbootehcache.dao.UserRepository;
import com.iyuyun.springbootehcache.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEhcacheApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		User u1 = userRepository.findByName("sarah");
		System.out.println("First Time:" + u1.getName());

		User u2 = userRepository.findByName("sarah");
		System.out.println("Second Time:" + u1.getName());

	}

}
