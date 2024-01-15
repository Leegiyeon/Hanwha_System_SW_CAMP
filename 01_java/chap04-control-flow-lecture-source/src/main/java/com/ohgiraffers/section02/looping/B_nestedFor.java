package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoNine() {
        int result = 0;

        for (int i = 2; i < 10; i++){
            System.out.println(i + "단수의 곱");
            for(int j = 1; j < 10; j++){
//                result = i*j;
                System.out.println(i + "*" + j + "=" + (i*j));
            }
            System.out.println();
        }

    }

    public void printUpgradeGugudanFromTwoNine() {
        /* 수업목표. inner for문을 메소드로 모듈화 */
        for (int dan = 2; dan < 10; dan++){
            System.out.println(dan + "수 출력");
            printGugudanof(dan);
            System.out.println();
        }

    }

    private void printGugudanof(int dan) {
        for (int su = 1; su < 10; su++){
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }

    public void printStars() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("정수를 입력하시오: ");
        num = sc.nextInt();


        for(int i = 0; i < num; i++){

            printSpace(num, i);
//            for (int j = 0; j < num-i; j++){
//                System.out.print(' ');
//            }

            printStar(i);
//            for (int k = 0; k < i + 1; k++){
//                System.out.print('*');
//            }

            System.out.println();
        }
    }

    private void printStar(int i) {
        for (int k = 0; k < i + 1; k++) {
            System.out.print('*');
        }
    }

    private void printSpace(int num, int i) {
        for (int j = 0; j < num - i; j++) {
            System.out.print(' ');
        }
    }


    /* 중첩된 for문의 흐름을 이해하고 적용할 수 있다. */

}

