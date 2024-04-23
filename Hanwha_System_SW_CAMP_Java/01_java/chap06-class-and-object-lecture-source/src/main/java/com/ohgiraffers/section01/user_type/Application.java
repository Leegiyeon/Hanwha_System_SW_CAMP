package com.ohgiraffers.section01.user_type;

import java.util.Arrays;

public class Application {

    /* 필기.
     *  객체지향 프로그래밍(OOP)이란?
     *  OOP(Object Oriented Programming language)
     *  추상화, 캡슐화, 상속, 다형성을 적용하여 유지보수성을 고려한
     *  응집력 높고 결합도 낮은 객체 위주의 개발 방식을 적용한 프로그래밍을 말한다.
     *
     * 필기.
     *  객체지향의 특징
     *  - 추상화(Abstraction)(추상화를 제외하면 이하가 3대 특징)
     *  - 캡슐화(Encapsulation)
     *  - 상속(Inheritance)
     *  - 다형성(Polymorphism)
    * */

    public static void main(String[] args) {

        /* 수업목표. 클래스가 무엇인지 이해하고 작성할 수 있다. */
        /* 설명.
         *  회원정보를 관리하기 위해 회원의 아이디, 비밀번호, 이름, 나이, 성별, 취미를 취급하여 관리하고자 한다.
         *  이 자료를 취급할 수 있는 방법을 생각해보자.
        * */

        /* 목차. 1. 변수를 이용한 회원 데이터 관리 */
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobby = new String[]{"축구", "볼링", "테니스"};

//        System.out.println("id: " + id);
//        System.out.println("pwd: " + pwd);
//        System.out.println("name: " + name);
//        System.out.println("age: " + age);
//        System.out.println("gender: " + gender);
//        System.out.println("hobby: " + Arrays.toString(hobby));

        /* 필기.
         *  이렇게 변수들로만 관리할 때 발생할 수 있는 문제점
         *   1. 많은 변수명들을 관리하기 힘들 수 있다.
         *   2. 메소드의 전달인자로 전달할 값이 너무 많아지므로 회원과 연관된 기능을 호출할 때, 매개변수도 많아진다.
         *   3. 메소드의 반환형으로 회원이라는 개념을 반환할 수 없다.
        * */


        Member member1 = new Member();
        Member member2 = new Member();

        System.out.println(member1.name);
        System.out.println(member2.name);

        member1.name = "김철수";
        member2.name = "김영희";

        System.out.println(member1.name);
        System.out.println(member2.name);


        member1.id = "user03";
        member1.pwd = "pass03";
        member1.age = 30;
        member1.gender = '남';
        member1.hobby = new String[]{"볼링", "하키"};

        System.out.println(printMember(member1).name);

        Member renameMember = printMember(member1);
        System.out.println(renameMember.age);
        System.out.println(Arrays.toString(renameMember.hobby));


    }

    private static Member printMember(Member member) {
        System.out.println("개명을 시작합니다.");
        member.name = "박길동";

        return member;
    }
}
