package com.ohgiraffers.section03.interfaceimplements;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 인터페이스에 대해 이해할 수 있다. */
        /*  인터페이스란?
         *   자바의 클래스와 유사한 형태이지만 추상메소드와
         *   상수필드(public static final)만 가질 수 있는 클래스의 변형체이다.
        * */

        /* 설명. 추상클래스와 인터페이스의 차이 중요 */

//        InterProduct ip1 = new InterProduct(); // 생성자가 없으므로 객체 생성 불가
        InterProduct ip2 = new Product();        // Memo. Product에서 implement로 InterProduct(인터페이스)를 구현함.
        ip2.defaultMethod();                     // Memo. 타입으로 활용가능(다형성, 타입은닉)

        /* Memo. 정보은닉: 필드, 메소드 은닉(캡슐화) / 타입 은닉(다형성) / 구현 은닉(다형성, 오버라이딩) */

    }
}
