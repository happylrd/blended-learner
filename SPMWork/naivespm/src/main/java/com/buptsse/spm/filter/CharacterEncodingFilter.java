package com.buptsse.spm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符编码过滤器
 * 全局搜索，并没有被显式使用
 */
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig;

    // 默认编码
    private String encoding = "UTF-8";

    // 是否保持request和response的编码一致
    private boolean forceEncoding = false;


    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public boolean isForceEncoding() {
        return forceEncoding;
    }

    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String tempE = filterConfig.getInitParameter("encoding");
        String tempFE = filterConfig.getInitParameter("forceEncoding");
        if (tempE != null) {
            encoding = tempE;
        }
        if ("true".equals(tempFE)) {
            forceEncoding = true;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        if (this.encoding != null
                && (this.forceEncoding || request.getCharacterEncoding() == null)) {
            request.setCharacterEncoding(this.encoding);
            if (this.forceEncoding) {
                response.setCharacterEncoding(this.encoding);// 与request的编码一致
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}