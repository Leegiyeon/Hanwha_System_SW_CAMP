package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpRequest;
import java.util.Map;

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


    @GetMapping("modify")
    public void modify(){}


    /* 설명.
    *   Request의 Parameter로 넘어오는 값들의 key값과 일치하는 변수명을 작성하고 @RequestParam
    *   어노테이션을 적용하면 알아서 값을 까내고 해당 매개변수의 자료형에 맞게 변환해준다.
    *   (Spring 부터는 컨트롤러의 파싱 작업이 간소화 된다는 것을 알 수 있다.)*/
    @PostMapping("modify")
    /* 설명.
    *   @RequestParam 의 속성
    *   1. defaultValue: 사용자의 입력값이 없거나 request의 parameter 키값과 일치하지 않는
    *                    매개변수 이름을 사용하면 매개변수가 가질 기본 default 값을 작성
    *   2. name: request parameter의 키 값과 다른 매개변수명을 사용하고 싶을때 request parameter의 키 값을 작성
    *   */
    public String modifyMenu(Model model, @RequestParam(defaultValue = "default", name = "name") String modifyName,        // Memo. @RequestParam은 생략해도 동작
                                          @RequestParam(defaultValue = "0") int modifyPrice){
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modify2")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameter){

        String modifyName = parameter.get("name2");
        int modifyPrice = Integer.valueOf(parameter.get("modifyPrice2"));
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void searchMenu(){}

    /* 설명. 핸들러 메소드에 우리가 작성한 클래스를 매개변수로 작성하면 스프링이 객체를 만들어 주고 setter 값도 주입해 준다.(Command 객체) */
    /* 설명. @ModelAttribute 어노테이션을 활용하면 커맨드 객체를 모델에도 담아주며 키값을 지정할 수 있다.(키 값이 없으면 타입의 낙타봉 표기법이 키값이 된다.) */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println("menu = " + menu);

        return "first/searchResult";
    }
}
