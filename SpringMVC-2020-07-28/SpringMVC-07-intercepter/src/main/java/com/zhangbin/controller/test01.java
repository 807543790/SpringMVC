package com.zhangbin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/19-15:25
 */
@RestController
public class test01 {
    @GetMapping("/t1")
    public String t1(){
        System.out.println("1");
        return "111";
    }
}
