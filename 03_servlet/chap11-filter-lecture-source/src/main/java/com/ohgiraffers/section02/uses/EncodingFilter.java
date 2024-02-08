package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명. 톰캣 버전 10 은 기본 인코딩 설정이 UTF-8이므로 다른처리를 해주지 않아도 된다. */
        /* 설명. 요청이 POST요청일 때, UTF-8로 인코딩 설정을 사전에 해주고 이후 필터나 서블릿으로 넘길 수 있다. */
        if ("POST".equals(httpRequest.getMethod())) {       // memo. 리터럴 값이 먼저 나오면 null 포인터를 예방할 수 있다.
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(httpRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
