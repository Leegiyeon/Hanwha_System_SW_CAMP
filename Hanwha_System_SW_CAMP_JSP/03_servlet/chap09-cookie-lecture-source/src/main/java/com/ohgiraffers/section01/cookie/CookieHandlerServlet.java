package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* 설명.
        *   쿠키(클라이언트의 브라우저에 저장)를 생성하고 사용하는 법
        *   1. 쿠키 인스턴스를 생성
        *   2. 해당 쿠기의 만료시간 설정
        *   3. 응답헤더에 쿠키를 담기
        *   4. 응답
        * */

        // Memo. 1
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // Memo. 2
        firstNameCookie.setMaxAge(60*60*24);        // 초단위 설정 (하루 설정)
        lastNameCookie.setMaxAge(60*60*12);        // 초단위 설정 (반나절 설정)

        // Memo. 3
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("redirect");

    }
}
