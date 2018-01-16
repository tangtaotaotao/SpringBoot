package com.iyuyun.springbootmultidatabases.dao;

import com.iyuyun.springbootmultidatabases.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long>{
}
