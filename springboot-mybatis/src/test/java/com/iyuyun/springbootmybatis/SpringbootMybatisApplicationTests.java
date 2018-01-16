package com.iyuyun.springbootmybatis;

import com.iyuyun.springbootmybatis.domain.User;
import com.iyuyun.springbootmybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void contextLoads() {
		userMapper.insert("A",1);
		userMapper.insert("B",2);
		User user = userMapper.findByName("A");
		Assert.assertEquals(1,user.getAge());

		System.out.println(userMapper.delete(22));
	}

}
