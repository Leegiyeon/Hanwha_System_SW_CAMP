package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    /* 설명. Handler 메소드(Controller의 어노테이션을 활용하여 요청방식 및 경로에 따라 각각 메소드가 작성 됨) */
    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)     // Memo. method 속성을 입력해주면 입력해준 방식으로만 적용됨(안하면 모든 방식동작)
    public String registMenu(Model model) {     // Memo. Model = 응답할 페이지의 재료를 담는 객체
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");
        model.addAttribute("message", "신규메뉴 등록 핸들러 메소드 호출");
        return "mappingResult";     // Memo. resources/template/의 경로 자동 생성해줌

    }


    @RequestMapping(value = "/menu/modify")
    public String modifyMenu(Model model) {
        System.out.println("/menu/modify 경로의 POST 요청 받아보기");
        model.addAttribute("message", "메뉴 수정 핸들러 메소드 호출");
        return "mappingResult";

    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }


    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }
}
