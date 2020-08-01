package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-18:03
 */
@Controller
public class EncodingController {

    //过滤器解决乱码
    @PostMapping("/demo")
    public String test(String name, Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "hello";
    }
}
