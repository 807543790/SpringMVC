package com.zhangbin.controller;

import com.zhangbin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-22:55
 */
@Controller
public class UserController {

    @ResponseBody//
    @RequestMapping("/json")
    public String test(){
        User user = new User(2, "zhangbin");
        return user.toString();
    }
}
