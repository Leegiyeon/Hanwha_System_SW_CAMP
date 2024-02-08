package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


/* 설명.
*   WebFilter 어노테이션에 Url 경로를 넣어 해당 요청 시, filter가 동작하게 한다.('/*'는 모든 경로) */
@WebFilter("/first/*")
public class FirstFilter implements Filter {
    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성됨...");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init() 자동 호출됨...");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter() 호출됨...");

        /* 설명. 다음 필터 또는 서블릿으로 가기전에 전처리를 위한 코드 작성 */

        /* 설명. FilterChain 에서 제공하는 doFilter()를 활용하여 다음 필터 또는 서블릿으로 진행시킬 수 있다. */
        filterChain.doFilter(servletRequest, servletResponse);


        /* 설명. 서블릿에서 클라이언트로 가기 전에 후처리를 위한 코드 작성 */
        System.out.println("서블릿 다녀옴");

    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy() 호출됨...");
    }
}
