package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {


        /* 설명.
        *   i18n 소프트웨어의 국제화(Internationalization 에서 첫 글자인 I 는 마지막 글자인 n 사이의 알파벳 개수가 18개)
        *   다국어 처리
        *   1. 언어, 지역별 번역
        *   2. OS/Platform 별 인코딩
        *   3. 문자열 치환 방법
        *   4. 국제화 UI
        *   5. 쓰기 방향의 차이
        *   6. 숫자 공백, 화폐, 날짜, 주소, 측정단위 등
        *   7. 타임존, 섬머타임 등 시각
        *   8. 문자열 정렬 방법
        *
        * 설명.
        *  우리가 다뤄본 예제는 1번에 해당
        *     */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String err404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String err500MessageKR = context.getMessage("error.500", new Object[]{"Hi", new java.util.Date()}, Locale.KOREA);


        String err404MessageUS = context.getMessage("error.404", null, Locale.US);
        String err500MessageUS = context.getMessage("error.500", new Object[]{"Hi", new java.util.Date()}, Locale.US);


        System.out.println("err404MessageKR = " + err404MessageKR);
        System.out.println("err500MessageKR = " + err500MessageKR);

        System.out.println("err404MessageUS = " + err404MessageUS);
        System.out.println("err500MessageUS = " + err500MessageUS);

    }
}
