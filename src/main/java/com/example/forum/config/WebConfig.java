package com.example.forum.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// src/main/java/com/example/forum/config/WebConfig.java
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (request.getSession().getAttribute("currentUser") == null
                        && request.getRequestURI().startsWith("/user/")) {
                    response.sendRedirect("/auth/login");
                    return false;
                }
                return true;
            }
        }).addPathPatterns("/user/**");
    }
}