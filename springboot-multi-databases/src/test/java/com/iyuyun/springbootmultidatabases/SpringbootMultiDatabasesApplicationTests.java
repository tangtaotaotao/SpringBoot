package com.iyuyun.springbootmultidatabases;

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
public class SpringbootMultiDatabasesApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp(){
		jdbcTemplate1.update("delete from t_user");
	}

	@Test
	public void contextLoads() {
		jdbcTemplate1.update("INSERT INTO t_user(id,name,age) VALUES (1,'tough',23)");

		Assert.assertEquals("1",jdbcTemplate1.queryForObject("select count(1) from t_user",String.class));

		jdbcTemplate2.update("INSERT INTO t_user(id,name,age) VALUES (2,'sarah',22)");

		Assert.assertEquals("2",jdbcTemplate1.queryForObject("select count(1) from t_user",String.class));
	}

}
