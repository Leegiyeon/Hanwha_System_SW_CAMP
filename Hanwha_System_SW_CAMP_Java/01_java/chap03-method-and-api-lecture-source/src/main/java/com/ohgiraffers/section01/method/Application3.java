package com.ohgiraffers.section01.method;

public class Application3 {

    static int global = 10;             // 전역 변수이자 클래스 변수


    public static void main(String[] args) {

        int global = 20;                // 지역 변수
        System.out.println("global 출력: " + global);
        System.out.println("global 출력: " + Application3.global);
        /* 수업목표. 메소드 전달 인자와 매개변수에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 필기.
         * 전달인자(argument)와 매개변수(parameter)를 이용한 메소드 호출
        * */

        /* 필기.
         * 변수의 종류(자료형과 다른 구분방식)
         * 1. 지역변수
         * 2. 매개변수
         * 3. 전역변수
         * 4. 클래스변수
        * */
        Application3 app3 = new Application3();
        app3.testMethod(26);                // 26은 전달인자이다.
        app3.testMethod(27);                // 26은 전달인자이다.
    }

    /* 설명. 정수를 주면 나이를 출력해주는 기능을 가진 메소드 (non-static)*/
    public void testMethod(int age){             // int age는 전달인자를 받는 지역변수인 매개변수이다.
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
