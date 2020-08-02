package com.zhangbin.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/2-21:00
 */
public class JsonUtils {

//    重载调用其他方法即可，方便。
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object,String dateFormat){

        ObjectMapper mapper = new ObjectMapper();
        //处理日期
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat date = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(date);

        try {
            //正常执行返回数据
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
            //报错返回空
             return null;
    }
}
