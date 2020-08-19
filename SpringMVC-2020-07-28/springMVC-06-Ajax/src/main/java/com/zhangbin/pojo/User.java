package com.zhangbin.pojo;

import lombok.Data;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/18-16:59
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
