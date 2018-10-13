package com.hospital.middleware;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PrivilegeMiddleWare extends HandlerInterceptorAdapter {

    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    private static List<String> whiteList;

    static {
        whiteList = new ArrayList<>();
        whiteList.add("/login");
        whiteList.add("/register");
        whiteList.add("/user/login");
        whiteList.add("/user/register");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录注册相关接口和默认页面 直接放行
        for (String uri : whiteList) {
            if (request.getServletPath().startsWith(uri)) {
                return true;
            }
        }
        if (request.getServletPath().equals("/")) {
            return true;
        }
        if (request.getSession().getAttribute("act") == null) {
            response.sendRedirect("/login");
            return false;
        }
        //int act = Integer.parseInt(request.getSession().getAttribute("act").toString());
        return super.preHandle(request, response, handler);
    }
}
