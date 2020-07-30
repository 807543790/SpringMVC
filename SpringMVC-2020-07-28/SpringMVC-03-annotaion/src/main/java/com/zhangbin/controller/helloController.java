package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/30-21:39
 */

@Controller
public class helloController {

    @RequestMapping("/hello")
    public String hello(Model model){
//        封装数据
        model.addAttribute("msg","张斌");
        return "hello";
    }
}
