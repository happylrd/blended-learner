package com.buptsse.spm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.buptsse.spm.domain.User;

/**
 * session校验
 */
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        checkSession((HttpServletRequest) request, (HttpServletResponse) response);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 校验SESSION是否有效，判断session里面是否有user
     */
    private void checkSession(HttpServletRequest request, HttpServletResponse response) {
        // 如果Session失效，跳回登录页面
        HttpSession session = request.getSession();
        try {
            if (session == null) {
                System.out.println("*****校验到session失效*****");

                // TODO: will be improved later
                response.sendRedirect("/SPM_Project");
            } else {

                // TODO: will be improved later
                User user = (User) session.getAttribute("user");

                if (user == null) {
                    System.out.println("*****校验到用户未登录*****");

                    // TODO: will be improved later
                    response.sendRedirect("/SPM_Project/jsp/relogin.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}