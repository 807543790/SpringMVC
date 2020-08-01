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