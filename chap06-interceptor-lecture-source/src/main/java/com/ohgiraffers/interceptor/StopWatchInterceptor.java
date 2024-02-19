package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* 설명.
*   인터셉터를 사용하는 경우
*   - 로그인 체크, 권한 체크, 프로그램 실행시간 계산 작업 로그 처리, 업로드 파일 처리, 로케일 설정 등
* */
@Configuration
public class StopWatchInterceptor implements HandlerInterceptor {

    /* 설명. 필터와 달리 인터셉터는 빈을 활용할 수 있다.(생성자 주입 활용) */
    private final MenuService MENUSERVICE;

    public StopWatchInterceptor(MenuService menuservice) {
        MENUSERVICE = menuservice;
    }

    /* 설명. boolean형에 따라 핸들러 메소드가 실행 될 수 도 있고 안 될수도 있도록 할 수 있으며 핸들러 메소드 이전 전처리 목적이다. */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        MENUSERVICE.method();
        System.out.println("preHandle 호출함 (핸들러 메소드 이전)");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 호출함 (핸들러 메소드 이후)");

        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        request.removeAttribute("startTime");

        modelAndView.addObject("interval", endTime -startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
