package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        /* 수업목표. 객체지향 프로그래밍에 대해 이해하고 객체와 클래스를 설계하여 프로그래밍 할 수 있다. */
        /* 필기.
         *  추상화란?
         *     공통된 부분을 추출하고 공통되지 않고 불필요한 부분을 제거한다는 의미를 지님
         *  목적. 유연성 확보
         *     유연성 확보는 여러 곳에 적용될 수 있는 유연한 객체를 의미하며, 재사용성이 높아질 수 있게 한다는 의미이다.
        * */

        /* 필기.
         *  프로그램 개요.
         *   카레이서가 자동차를 운전하는 프로그램
         *  시스템 요구사항.
         *   1. 카레이서는 시동 걸기, 가속, 제동, 시동 끄기를 할 수 있다.
         *   2. 자동차는 시동 걸기, 전진, 멈추기, 시동 끄기를 할 수 있다.
         *   3. 자동차는 처음에 멈춘상태로 대기한다.
         *   4. 카레이서는 먼저 자동차에 시동을 건다. 이미 걸렸을 경우 다시 시동걸 수 없다.
         *   5. 카레이서가 가속을 하면 자동차는 시속 10키로미터 증가하며 전진한다.
         *   6. 자동차가 달리는 중에 카레이서가 제동하면 바로 시속 0키로미터로 떨어지며 멈춘다.
         *   7. 카레이서가 제동할 때, 자동차가 달리는 중이 아니면 이미 멈춰있다고 안내해준다.
         *   8. 자동차가 달리는 중이면 시동을 끌 수 없다.
        * */

        // 필기. 기능 > 상태값(속성)

        /* 설명. 카레이서 등장 */
        CarRacer racer = new CarRacer();

        Scanner sc = new Scanner(System.in);

        /* 설명. 카레이서에게 명령하기 위한 메뉴 출력 */
        while (true) {
            System.out.println("=============카레이싱 프로그램==============");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 전진");
            System.out.println("3. 정지");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴선택: ");
            int input = sc.nextInt();


            switch (input) {
                case 1: racer.startUp();
                    break;
                case 2: racer.stepAccelator();
                    break;
                case 3: racer.stepBreak();
                    break;
                case 4: racer.turnOff();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }

            if (input == 9) {
                break;
            }
        }

        Car car = new Car();


    }
}
