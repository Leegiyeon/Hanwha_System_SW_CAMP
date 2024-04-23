package com.ohgiraffers.section02.string;

public class Application4 {

    public static void main(String[] args) {

        /* 수업목표. escape 문자에 대해 이해하고 적용할 수 있다. */
        /* 필기.
         *  이스케이프(escape) 문자
         *  문자열 내에서 사용하는 특수기능을 위한 문자이다.
        * */

        /* 필기.
         *  \n: 개행
         *  \t: 탭
         *  \': 작은따옴표
         *  \": 큰따옴표
         *  \\: 역슬래시 표시
        * */

        System.out.println("안녕하십니까!\n어이~\n저는!\n어이~\nXX대학교!\n어이~....");
        System.out.println("안녕하십니까!\t어이~\t저는!\t어이~\tXX대학교!\t어이~....");
        System.out.println("안녕하십니까!'어이~'저는!\"어이~\"XX대학교!어이~....");

        System.out.printf("원주율은 %.2f 입니다.", 3.141592);



    }
}
