package com.zhangbin.controller;

import com.zhangbin.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/11-16:47
 */
@RestController
public class AjaxController {

    @RequestMapping("/ajax")
    public String text01(){
        return "1111";
    }

    @RequestMapping("a1")
    public void a1(String name, Model model){
        if("zhangbin".equals(name)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> lestuser = new ArrayList<User>();
        lestuser.add(new User(1,"zhangbin",15));
        lestuser.add(new User(2,"zhangbin1",151));
        lestuser.add(new User(3,"zhangbin2",152));
        lestuser.add(new User(4,"zhangbin3",153));
        return lestuser;
    }
}
