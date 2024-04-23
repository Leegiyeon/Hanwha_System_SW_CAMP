package com.ohgiraffers.section02.formdata;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/* 설명. form 태그의 method="post"로 Post 요청으로 넘어온 데이터(parameter) 꺼내보기*/
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    public FormDataTestServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");          // Memo. TomCat 9버전 이하는 post요청 시, 인코딩을 설정 해주어야 한다.

        /* 설명. 키값을 통해 파라미터를 하나씩 꺼내는 과정은 get방식과 동일 */
        String name = req.getParameter("name");
        System.out.println("name: " + name);

        int age = Integer.valueOf(req.getParameter("age"));
        System.out.println("age: " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday: " + birthday);

        String gender = req.getParameter("gender");
        System.out.println("gender: " + gender);

        String national = req.getParameter("national");
        System.out.println("national: " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("Arrays.toString(hobbies): " + Arrays.toString(hobbies));

        /* 설명. 요청으로 넘어오는 파라미터들의 키 값들을 한번에 확인하기 */
        Enumeration<String> names = req.getParameterNames();

        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }


    }
}
