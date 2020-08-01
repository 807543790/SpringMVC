package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-16:52
 */
@Controller
public class Redirect {

    @GetMapping("/delete")
    public String Test(){
//        默认就是转发
//        return "test;"

//        重定向
        return  "redirect:/index.jsp";
    }
}
