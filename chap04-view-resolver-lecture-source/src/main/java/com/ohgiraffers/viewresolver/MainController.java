package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/*")               // 설명. 요청 경로 상 첫번째 경로 스텝을 처리하는 컨트롤러
public class MainController {

    /* 설명.
    *   ViewResolver 인터페이스를 구현한 ThymeleafViewResolver가 처리
    *   접두사: resource/templates/
    *   접미사: .html
    *   핸들러 메소드가 반환하는 String 값 전 후로 접두사와 접미사가 붙어 view를 찾게된다. */


    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }
}
