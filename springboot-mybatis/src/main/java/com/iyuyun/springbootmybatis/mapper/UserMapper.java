package com.iyuyun.springbootmybatis.mapper;

import com.iyuyun.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO t_user(name,age) values(#{name},#{age})")
    int insert(@Param("name") String name,@Param("age") int age);

    @Delete("delete from t_user where age = #{age}")
    int delete(@Param("age") int age);


}
