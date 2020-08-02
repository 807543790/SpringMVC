# SpringMVC
坚持，加油！2020-07-28
# SpringMVC-01-servlet实现开发

# SpringMVC-02-使用mvc底层开发
    
# SpringMVC-03-使用注解开发

第一步：配置注册DispatcherServlet，【固定写法】
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
    
        <!--1.注册DispatcherServlet-->
        <servlet>
            <servlet-name>springmvc</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    
            <!--关联一个springmvc的配置文件：【servlet-name】servlet.xml-->
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:springmvc-servlet.xml</param-value>
            </init-param>
    
            <!--启动级别1级-->
            <load-on-startup>1</load-on-startup>
        </servlet>
    
        <!---->
        <!--  /   匹配所有的请求:不包括.jsp-->
        <!--  /*  匹配所有的请求:包括.jsp-->
        <servlet-mapping>
            <servlet-name>springmvc</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
    
    </web-app>
```
第二步：配置mvc.XML文件【固定写法】
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:mvc="http://www.springframework.org/schema/mvc"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
        <!--自动扫描包，让指包下的注解生效，用IOC容易统一管理-->
        <context:component-scan base-package="com.zhangbin.controller"/>
        <!--让springMVC不处理静态资源 css html等-->
        <mvc:default-servlet-handler/>
         <!--直接MVC的注解。省掉处理器，适配器，映射器-->
        <mvc:annotation-driven/>
        <!--视图解析器：DispatcherServlet给他的ModelAndView-->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
            <!--前缀-->
            <property name="prefix" value="/WEB-INF/jsp/"/>
            <!--后缀-->
            <property name="suffix" value=".jsp"/>
        </bean>
    
    
    </beans>
```
第三步：使用注解编写Controller层
```java
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

```
第四步，编写跳转的JSP文件，实现跳转
```jsp
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
        ${msg}
    </body>
    </html>

```


# SpringMVC-04-restFul风格
```java
package com.zhangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-14:57
 */
    @Controller
    public class RestFulController {
    
    //    http://localhost:8080/add?a=1&b=2 原来的风格
    //    http://localhost:8080/add/a/b     restFul风格:添加注解@RathVariable,修改@ResquestMapping里的路径
    
    //    效果相等
        //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.DELETE)
    //    @DeleteMapping("/add/{a}/{b}")
    
    //    效果相等
        //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
        @GetMapping("/add/{a}/{b}")
        public String test01(@PathVariable int a,@PathVariable int b, Model model){
            int src = a + b;
            model.addAttribute("msg","结果为=" + src);
            return "hello";
        }
    
        //    效果相等
        //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
        @DeleteMapping("/add/{a}/{b}")
        public String test02(@PathVariable int a,@PathVariable int b, Model model){
            int src = a + b;
            model.addAttribute("msg","结果为=" + src);
            return "hello";
        }
    }

```

####4.1转发，重定向
```java
    
/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-16:52
 */
    @Controller
    public class Redirect {
    
        @GetMapping("/delete")
        public String Test(){
    //        默认就是转发
    //        return "test;"
    
    //        重定向
            return  "redirect:/index.jsp";
        }
    }

```

####4.2前端数据请求及参数回显
```java
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
    
        
    
    }

```
####4.3model-modelAndView-modelMap的区别

    /**  【区别】
             *  model：只有几个方法值只适用于储存数据，简化了新手对molder对象的理解和操作
             *
             *  modelMap：继承了linkedMap,除了实现自身的方法，同时还继承了linkedMap的方法和特征
             *
             *  modelAndView ：可以存储数据的同时，可以进行设置返回的逻辑视图进行控制展示层的跳转
             */

####4.4乱码
web.xml文件添加
```xml
    <!--配置SpringMVC的乱码过滤-->
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

```

# SpringMVC-05-JSON
1.学习的注解
```java

    @RestController
    这个注解表示该方法下的所有都不会走视图解析器，会直接返回一个字符串，和ResponseBody差不多
    
    @ResponseBody
    这个注解表示不会走视图解析器，会直接返回一个字符串，配合@Controller注解使用
```
2.jackson传输数据
    
    步骤一：导入包
    <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
                <version>2.11.0</version>
    </dependency>
    
    步骤二：配置JSON乱码问题
        <!--json乱码-->
        <mvc:annotation-driven>
            <mvc:message-converters>
                <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                    <constructor-arg value="UTF-8"/>
                </bean>
                <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                    <property name="objectMapper">
                        <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                            <property name="failOnEmptyBeans" value="false"></property>
                        </bean>
                    </property>
                </bean>
            </mvc:message-converters>
        </mvc:annotation-driven>
        
    步骤三：直接使用即可
    
3.使用jackson
```java
    package com.zhangbin.controller;
    
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
    }

```

4.学习JSON工具类的思想
```java
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

```

###使用fastjson的JSON

    1.导入包
       <!--阿里巴巴json-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>1.2.68</version>
            </dependency>
    2.直接调用
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