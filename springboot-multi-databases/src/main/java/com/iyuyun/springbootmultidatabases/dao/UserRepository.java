package com.iyuyun.springbootmultidatabases.dao;

import com.iyuyun.springbootmultidatabases.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

}
