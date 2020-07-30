package com.zhangbin.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/29-11:10
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView modelAndView = new ModelAndView();
//        封装对象，放在ModelAndView中
        modelAndView.addObject("msg","HelloController");
//        封装要跳转的视图，放在ModelAndView中
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}
