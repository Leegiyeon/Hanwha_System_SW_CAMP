package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
//        System.out.println("====== Select All Members ======");
//        List<MemberDTO> members = memberService.findAllMembers();
//        members.forEach(System.out::println);
//        System.out.println();

        System.out.println("====== Select One Member ======");
        System.out.println(memberService.findMemberBy(1));
        System.out.println();

        /* 설명. 존재하지 않는 회원 인덱스 조회 */
        System.out.println("====== Select One Member Error ======");
        System.out.println(memberService.findMemberBy(3));




    }
}
