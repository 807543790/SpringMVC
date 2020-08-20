package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/19-19:09
 */
@Controller
public class UserController {
//    跳转至首页
    @RequestMapping("/gomain")
    public String main(){
        return "main";
    }
//    跳转至用户登录
    @RequestMapping("/gouser")
    public String  login(){
        System.out.println("跳转到用户登录");
        return "user";
    }
//用户登录提交时
    @RequestMapping("/user")
    public String User(HttpSession session,String username){
        session.setAttribute("username",username);
        System.out.println(username);
        return "main";
    }
//用户注销
    @RequestMapping("/out")
    public String out(HttpSession session){
        session.invalidate();
        return "user";
    }
}
