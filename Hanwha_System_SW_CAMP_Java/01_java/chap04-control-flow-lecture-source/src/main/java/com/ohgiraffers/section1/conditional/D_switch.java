package com.ohgiraffers.section1.conditional;

import java.util.Scanner;

public class D_switch {
    public void testSwitchStatement() {
        /* 수업목표. switch문 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        Scanner sc = new Scanner(System.in);
        System.out.print("본인의 등급을 입력하시오: ");
        char grade = sc.nextLine().charAt(0);
        int point = 0;
        boolean flag = true;

        switch (grade) {
            case 'G':
                point += 10;
            case 'S':
                point += 10;
            case 'B':
                point += 10;
                break;
            default:
                flag = false;
                System.out.println("어디 회원 등급이세요?");
        }
        if (flag)
            System.out.println("당신의 등급은 " + grade + "등급이며, 현재 포인트는 " + point + "점 입니다.");
        else
            System.out.println("이참에 회원가입 하시죠.");
    }
}
