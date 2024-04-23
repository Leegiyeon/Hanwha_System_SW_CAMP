package com.ohgiraffers.section02.encapsulation.resolved;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 접근제어자와 캡슐화에 대해 이해하고 직접 필드접근을 막는 이유를 이해할 수 있다. */

        Monster monster = new Monster();
//        monster.name = "드라큘라";
//        monster.hp = 1000;

        /* 설명. 필드에 직접접근대신 메소드를 통해 우회 접근한다. */
        monster.setInfo1("드라큘라");
        monster.setInfo2(1000);

        /* 설명.
         *  캡슐화란?
         *  캡슐화는 유지보수를 증가시키기 위해 필드의 직접 접근을 제한 하고
         *  Public 메소드를 이용하여 간접적으로 접근하여 사용할 수 있도록 한 것.
         *  클래스 작성 시, 특별한 목적이 있지 않다면 캡슐화를 기본적으로 적용하는 것을 기본 원칙으로 함
        * */
    }
}
