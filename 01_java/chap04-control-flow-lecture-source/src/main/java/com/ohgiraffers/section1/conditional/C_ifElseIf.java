package com.ohgiraffers.section1.conditional;

import java.util.Scanner;

public class C_ifElseIf {
    public void testSimpleIfElseIfStatement() {
        /* 수업목표. if-else if 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        Scanner sc = new Scanner(System.in);
        System.out.println("산 속에서 나무를 하던 나무꾼이 연못에 도끼를 빠뜨리고 말았다.");
        System.out.println("연못에서 산신령이 나타나 금도끼, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("나무꾼에게 셋 중 어떤 도끼가 나무꾼의 도끼인지 물어보았다. ");

        System.out.print("어는 도끼가 너의 도끼냐? (1.금도끼 2.은도끼 3.쇠도끼) : ");
        int input = sc.nextInt();

        if (input == 1) {
            System.out.println("이런 거짓말쟁이!!");
        } else if (input == 2) {
            System.out.println("욕심이 과하진 않으나 거짓말을 하는구나.");
        } else {
            System.out.println("오호 솔직하게 이야기 했으니 세가지 모두다 가져가거라");
        }

        System.out.println("그렇게 산신령은 다시 연못 속으로 사라지고 말았다...");
    }

    public void testNestedIfElseIfStatement() {
        /* 수업목표. if-else if 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        /* 필기.
         * 90점 이상 'A', 80점 이상 'B', 70점 이상 'C', 60점 이상 'D' 이외 60점 미만 'F'
         * (추가로 각 등급의 중간점수(95, 85, 75...) 이상인 경우 '+')
         * */

        Scanner sc = new Scanner(System.in);
        System.out.print("학생이름을 입력해주세요: ");
        String name = sc.nextLine();

        int point = 0;
        while (point == 0) {
            System.out.print("점수를 입력해주세요: ");
            point = sc.nextInt();
            if (point > 100) {
                System.out.println("점수의 범위는 100점까지 입니다.");
                point = 0;
            }
        }

        String grade = "";
        if (point >= 90) {
            grade = "A";
        } else if (point >= 80) {
            grade = "B";
        } else if (point >= 70) {
            grade = "C";
        } else if (point >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        if (point % 10 >= 5 && point > 60|| point == 100)
            grade += "+";

        System.out.println(name + " 학생의 점수는 " + point + "이고, 등급은 " + grade + "입니다.");
        System.out.println("프로그램을 종료합니다.");

    }
}
