package com.ohgiraffers.section01.extend;

public class FireCar extends Car {

    public FireCar() {
        super();
        System.out.println("FireCar 클래스의 기본 생성자 호출됨...");
    }

    @Override   // 설명. 가독성, 메소드명이 부모클래스와 다른 경우 에러 표시
    public void soundHorn() {
        System.out.println("빠아아아아아앙!! 빠아아아아아앙!!");
    }

    public void sprayWater(){
        System.out.println("불이 난 곳을 발견했습니다. 물을 뿌립니다 ============================3");
    }
}
