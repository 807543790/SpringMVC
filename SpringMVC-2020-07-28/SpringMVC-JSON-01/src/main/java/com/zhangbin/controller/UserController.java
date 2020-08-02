package com.zhangbin.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zhangbin.pojo.User;
import com.zhangbin.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-22:55
 */
//@Controller
@RestController//这个注解表示该方法下的所有都不会走视图解析器，会直接返回一个字符串，和ResponseBody差不多
public class UserController {

    //【1】json输出对象
    @ResponseBody//这个注解表示不会走视图解析器，会直接返回一个字符串，配合@Controller注解使用
    @RequestMapping( "/json")
//  @RequestMapping(value = "/json",produces = "application/json;charset=utf-8")
    //produces = "application/json;charset=utf-8 解决JSON乱码问题
    public String test() throws JsonProcessingException {
//        创建jackson
        ObjectMapper mapper = new ObjectMapper();

        User user = new User(2, "张斌");

//        将user数据转化为json
        String string = mapper.writeValueAsString(user);
        return string;
    }

//   【2】json输出数组
    @RequestMapping( "/json1")
    public String test1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        ArrayList<User> list = new ArrayList<User>();

        User user = new User(1, "张斌");
        User user1 = new User(2, "张斌");
        User user2 = new User(3, "张斌");
        User user3 = new User(4, "张斌");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);


        String string = mapper.writeValueAsString(list);
        return string;
    }

    //【3】json输出日期
    @RequestMapping( "/json2")
    public String test2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
//创建日期
        Date date = new Date();
//        方式一
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.format(date);

//        方式二
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return mapper.writeValueAsString(date);
    }

    //【4】json输出日期，使用自定义工具类
    @RequestMapping( "/json3")
    public String test3() throws JsonProcessingException {

//        将数据传输给工具类，获取JSON时间
        return JsonUtils.getJson(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    //【5】使用fastjson，阿里巴巴写的
    @RequestMapping( "/json4")
    public String test4() throws JsonProcessingException {

        ArrayList<User> list = new ArrayList<User>();

        User user = new User(1, "张斌");
        User user1 = new User(2, "张斌");
        User user2 = new User(3, "张斌");
        User user3 = new User(4, "张斌");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        //  使用alibaba的JSON
        String string = JSON.toJSONString(list);

        return string;
    }
}
