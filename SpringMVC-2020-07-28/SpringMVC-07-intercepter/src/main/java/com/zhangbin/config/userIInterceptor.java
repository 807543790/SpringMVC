package com.zhangbin.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/19-19:20
 */
public class userIInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        获取session
        HttpSession session = request.getSession();
//判断为登录提交时通过
        if(request.getRequestURI().contains("user")){
            System.out.println("登录提交操作");
            return true;
        }
//判断session不为空(即用户已经登录)为通过
        if(session.getAttribute("username") != null){
            System.out.println("用户已登录，直接进入首页");
            return true;
        };
//以上所有条件不符合，拦截至user。jsp页面
        System.out.println("没有符合操作，跳转至登录页面");
        request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
