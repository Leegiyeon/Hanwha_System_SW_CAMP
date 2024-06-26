package com.ohgiraffers.section03.abstraction;

public class CarRacer {

    /* 설명. 차 한대(Car 객체 하나)를 필드로 가진다. */
    private Car mycar = new Car();

    /*설명. 자신이 보유한 차량에 시동을 건다.*/
    public void startUp() {
        this.mycar.startUp();
    }

    public void stepAccelator() {
        this.mycar.go();
    }

    public void stepBreak() {
        this.mycar.stop();
    }

    public void turnOff() {
        this.mycar.turnOff();
    }
}
