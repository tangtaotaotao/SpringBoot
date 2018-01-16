package com.iyuyun.springbootmultidatabases;

import com.iyuyun.springbootmultidatabases.dao.MessageRepository;
import com.iyuyun.springbootmultidatabases.dao.UserRepository;
import com.iyuyun.springbootmultidatabases.domain.Message;
import com.iyuyun.springbootmultidatabases.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageRepository messageRepository;

	@Before
	public void setUp(){
		userRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		userRepository.save(new User("tough",1));
		userRepository.save(new User("sarah",2));

		Assert.assertEquals(2,userRepository.count());

		messageRepository.save(new Message("404","page not found"));

		Assert.assertEquals(1,messageRepository.count());
	}

}
