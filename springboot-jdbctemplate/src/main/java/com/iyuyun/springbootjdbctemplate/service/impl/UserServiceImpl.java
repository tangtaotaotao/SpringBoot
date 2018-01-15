package com.iyuyun.springbootjdbctemplate.service.impl;

import com.iyuyun.springbootjdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO t_jdbcTemp(username,age) values(?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM t_jdbcTemp WHERE username = ?",name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from t_jdbcTemp",Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM t_jdbcTemp");
    }
}
