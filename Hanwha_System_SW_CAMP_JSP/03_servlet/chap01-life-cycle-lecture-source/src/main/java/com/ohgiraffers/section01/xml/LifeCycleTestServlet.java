package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {


    /* 설명. 최초 호출 */
    public LifeCycleTestServlet() {
        System.out.println("xml 방식 기본 생성자 실행!");
    }

    /* 설명. 서블릿 객체 생서 후 자동 호출 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메소드 호출!");
    }

    /* 설명. 컨테이너 종료 시 호출 */
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메소드 호출!");
    }

    /* 설명. init()이후 동작, 두번째 요청부터 service만 호출 됨*/
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        System.out.println("xml 매핑 service() 메소드 호출!");
    }

    /* Memo. init() > service()(반복 doGet, doPost) > destroy() */

}