package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /* 설명. 리다이렉트 이후 오는 서블릿은 기존과 다른 새로운 request와 response 객체로 오게 된다. */
        System.out.println("리다이렉트 이후 request의 attribute: " + req.getAttribute("test"));

        /* 설명. 파라미터가 넘어오면 request 객체가 달라져도 값이 전달되어 온다. */
        System.out.println("리다이렉트 이후 request의 parameter: " + req.getParameter("test"));

        /* 설명.
         *  redirect 시 request 의 attribute 개념으로 다른 서블릿에게 값을 전달할 수 없다.
         *  (다음 서블릿으로 클라이언트가 새로 요청하면 기존의 request 와 response 객체가 아닌 새로운 객체를 생성하여 요청하기 때문)
         *  cookie, session은 같은 공간을 활용하는 방법을 사용하여 값을 공유할 수 있다.
        * */

        /* 설명.
         *  1. 포워딩: request, response 객체를 유지하여 요청 처리를 할 경우 사용
         *           (다음 서블릿으로 값 전달 가능)
         *  2. 리다이렉트: 클라이언트가 새로고침을 할때마다 처음 요청하는 서블릿을 재호출하고 싶지 않는 경우 사용
         *               (쿼리 스트링 형태로 parameter의 개념을 활용하여 값을 공유할 수 있다.)
        * */

    }
}
