package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectSurvlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. 리다이렉트로 넘어온 JSESSIONID와 동일한 값을 담은 Session 객체 생성*/
        HttpSession session = req.getSession();

        String firstName = (String)session.getAttribute("firstName");
        String lastName = (String)session.getAttribute("lastName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>your FirstName is ")
                .append(firstName)
                .append("\n and LastName is ")
                .append(lastName)
                .append("</h3)");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();



    }
}
