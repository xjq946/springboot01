package com.kyexpress.ec.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

/*
    @RequestMapping({"/","/index.html"})
    public String login(){
        return "login";
    }
*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }
}
