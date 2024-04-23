package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* 설명.
        *   요청이 서블릿으로 들어올 때, HttpServletRequest는 JSESSIONID 라는 값이 Header에 같이
        *   포함되어 넘어온다. 그럼 해당 JSESSIONID 에 맞는 HttpSession 객체를 생성하여 해당 사용자를
        *   위한 전용 저장 공간을 제공하게 된다.
        *   (요청을 보낸 사람 전용 Session 저장 공간을 생성하게 된다.)*/
        HttpSession session = req.getSession();

        /* 설명. Session 객체의 기본 유지 시간은 30분으로 설정되어 있다. */
        System.out.println("session 객체 유지 default 시간(초) = " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60 * 10);    // Memo. 10분으로 지정
        System.out.println("session 객체 유지 시간(초) = " + session.getMaxInactiveInterval());

        /* 설명. JSESSIONID 출력*/
        System.out.println("session.getId() = " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");

    }
}
