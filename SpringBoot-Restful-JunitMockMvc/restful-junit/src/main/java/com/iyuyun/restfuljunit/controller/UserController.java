package com.iyuyun.restfuljunit.controller;

import com.iyuyun.restfuljunit.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    // 创建线程安全的Map
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 处理"/users/"的Get请求
     * @return
     */
    @GetMapping(value = "/")
    public List<User> getUserList(){
        List<User> usersList = new ArrayList<User>(users.values());
        return usersList;
    }

    /**
     * 处理"/users/"的POST请求
     * @param user
     * @return
     */
    @PostMapping(value = "/")
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    /**
     * 获取url中id的user信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    /**
     * 通过id更新user信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        User u = users.get(id);
        u.setAge(user.getAge());
        u.setUsername(user.getUsername());
        users.put(id,u);
        return "success";
    }

    /**
     * 通过id删除指定的user
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id ){
        users.remove(id);
        return "success";
    }

}
