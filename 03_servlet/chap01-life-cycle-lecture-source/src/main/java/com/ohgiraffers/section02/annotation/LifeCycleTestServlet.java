package com.ohgiraffers.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    public LifeCycleTestServlet() {
        System.out.println("Annotaion 방식 기본 생성자 실행...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Annotaion 방식 init() 실행...");
    }


    @Override
    public void destroy() {
        System.out.println("Annotaion 방식 destroy() 실행...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Annotaion 방식 service() 실행...");
    }
}
