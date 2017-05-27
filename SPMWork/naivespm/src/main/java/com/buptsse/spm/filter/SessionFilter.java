package com.buptsse.spm.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.buptsse.spm.common.Const;
import com.buptsse.spm.domain.User;

import java.io.IOException;

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

    private void checkSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            // case: session失效
            if (session == null) {
                // TODO: will be improved later
                response.sendRedirect("/SPM_Project");
            } else {
                User user = (User) session.getAttribute(Const.CURRENT_USER);
                // case: user has not login
                if (user == null) {
                    // TODO: will be improved later
                    response.sendRedirect("/SPM_Project/jsp/relogin.jsp");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}