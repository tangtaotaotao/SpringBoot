package com.iyuyun.springbootspringdatajpa.dao;

import com.iyuyun.springbootspringdatajpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByUsername(String name);

    User findByUsernameAndAge(String name,int age);

    @Query(value = "from User u where u.username=:name")
    User findUser(@Param("name") String name);
}
