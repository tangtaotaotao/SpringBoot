package com.iyuyun.springbootehcache.dao;

import com.iyuyun.springbootehcache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Long>{

    @Cacheable
    User findByName(String sarah);
}
