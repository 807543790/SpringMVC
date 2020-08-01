package com.zhangbin.pojo;

import lombok.Data;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-22:54
 */
@Data
public class User {
    private int id;
    private String name;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
