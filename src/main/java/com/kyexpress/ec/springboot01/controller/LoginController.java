package com.kyexpress.ec.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)&&password.equals("123456")) {
            //防止表单重复提交，重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户名或密码错误！");
            return "login";
        }

    }
}
