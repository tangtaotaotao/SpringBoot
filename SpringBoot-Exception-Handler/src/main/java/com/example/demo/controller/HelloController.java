package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hi")
    public String hello(Model model, @RequestParam(value="name", required = false ,defaultValue = "World") String name){
        model.addAttribute("name",name);
        return "hello";
    }

    /**
     * 第一种情况，直接抛出异常
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/err")
    public String err() throws Exception {
        throw new Exception("SomeThing Wrong!");
    }

    /**
     * 不刷新页面直接返回错误
     * @return
     * @throws MyException
     */
    @RequestMapping(value = "/jsonErr")
    public String jsonExcep() throws MyException {
        throw new MyException("SomeThing Wrong With Json");
    }
}
