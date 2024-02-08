package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionSurvlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        System.out.println("Attribute 만료 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("Attribute 만료 전 lastName: " + session.getAttribute("lastName"));

        session.invalidate();       // HttpSession 객체의 Attribute 값 무효화

        System.out.println("Attribute 만료 후 firstName: " + session.getAttribute("firstName"));
        System.out.println("Attribute 만료 후 lastName: " + session.getAttribute("lastName"));


        /* 설명. session 이 무효화 되어 attribute 를 가져올 수 없게 됨 -> 500 에러 */
    }

}
