package com.zhangbin.controller;

import com.zhangbin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-17:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    1.获取前端参数
    @GetMapping("/t1")
//    接收前端参数
    public String test01(String name, Model model){
        System.out.println(name);
//        将返回结果传输给前端
        model.addAttribute("msg",name);
//         跳转视图
        return "hello";
    }


//    2.参数字段与前端字段不同的办法【建议字段是否一致都加上@RequestParam注解，该注解和MyBatis里的@Param相似】
    @GetMapping("/t2")
//    接收前端参数
    public String test02(@RequestParam("username") String name, Model model){
        System.out.println(name);
//        将返回结果传输给前端
        model.addAttribute("msg",name);
//         跳转视图
        return "hello";
    }

//    3.前端接受对象 【只有前端传输来的参数和对象字段保持一致才能取得到，字段名不一致就取不到】
    @GetMapping("/t3")
    //    接收前端参数
    public String test03(User user){
        System.out.println(user);
    //         跳转视图
        return "hello";
    }

    /**  【区别】
     *  model：只有几个方法值只适用于储存数据，简化了新手对molder对象的理解和操作
     *
     *  modelMap：继承了linkedMap,除了实现自身的方法，同时还继承了linkedMap的方法和特征
     *
     *  modelAndView ：可以存储数据的同时，可以进行设置返回的逻辑视图进行控制展示层的跳转
     */

}
