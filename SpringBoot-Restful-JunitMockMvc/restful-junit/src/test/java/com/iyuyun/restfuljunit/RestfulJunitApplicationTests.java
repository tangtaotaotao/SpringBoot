package com.iyuyun.restfuljunit;

import com.iyuyun.restfuljunit.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulJunitApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void contextLoads() throws Exception {

		// 1.get查找user列表
			mvc.perform(get("/users/"))
					.andExpect(status().isOk())
					.andExpect(content().string(equalTo("[]")));

			// 2.post 提交一个user
        RequestBuilder request = null;
        request = post("/users/")
                        .param("id","1")
                        .param("username","test1")
                        .param("age","22");
        mvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo("success")));
        //"[{\"id\":1,\"username\":\"test1\",\"age\":22}]"

        //get获取user列表，应有刚插入数据
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"username\":\"test1\",\"age\":\"22\"}]")));




	}

}
