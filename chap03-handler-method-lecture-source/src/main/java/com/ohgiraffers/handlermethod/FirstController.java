package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpRequest;

@Controller

/* 설명. 현재의 controller 클래스에 작성할 핸들러 메소드들이 모두 /first/XXX 경로의 요청을 받게 될때 클래스에 어노테이션 주가 가능 */
@RequestMapping("/first")
public class FirstController {

    /* 설명. 반환형이 void인 핸들러 메소드는 요청 경로자체가 view의 경로 및 이름을 반환한 것으로 바로 해석 된다. */
    @GetMapping("regist")   // Memo. /regist or regist 가능
//    public String regist() {
//        return "/first/regist";
//    }
    public void regist() {}

    /* 설명. request를 쓰게된다면 request 개념은 사용자의 입력값이 존재, model은 동적페이지의 재료를 담는 용도로 사용*/
    @PostMapping("regist")
//    public String registMenu(HttpServletRequest request) {
    public String registMenu(WebRequest request, Model model) {
        String name = request.getParameter("name");
//        System.out.println("name = " + name);

        int price = Integer.valueOf(request.getParameter("price"));
        int categoryCode = Integer.valueOf(request.getParameter("categoryCode"));
        String message = name + "을(를) 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }
}
