package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명. 인터셉ㅌ터 추가 및 static 리소스 호출 경로 등록 설정 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private StopWatchInterceptor stopWatchInterceptor;

    @Autowired
    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor){
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    /* 설명. interceptor를 따로 등록해 주어야 실제로 동작하는 interceptor가 된다.*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(stopWatchInterceptor).excludePathPatterns("/css/**");   // Memo. excludePathPatterns 를 등록해준 경호 요청은 인터셉터가 가로채지 않음.
    }



}
