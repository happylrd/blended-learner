package io.happylrd.intercepter;

import io.happylrd.service.serviceImpl.ActionLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final String USER_SESSION_ATTR_NAME = "userInfo";
    private static final String NOT_INTERCEPT_PATH = ".*/((static)|(login)|(signUp)|(doSignUp)).*";
    private static final String ADD_PATH = ".*/((static)|(login)|(doSignUp)).*";

    @Autowired
    ActionLogServiceImpl service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String path = request.getServletPath();

        if (!path.matches(ADD_PATH)) {
            service.add(request);
        }

        if (path.matches(NOT_INTERCEPT_PATH)) {
            return true;
        } else {
            try {
                if (request.getSession().getAttribute(USER_SESSION_ATTR_NAME) == null) {
                    response.sendRedirect(request.getContextPath() + "/mvc/login");
                    return false;
                }
            } catch (IOException e) {
                response.sendRedirect(request.getContextPath() + "/mvc/login");
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
