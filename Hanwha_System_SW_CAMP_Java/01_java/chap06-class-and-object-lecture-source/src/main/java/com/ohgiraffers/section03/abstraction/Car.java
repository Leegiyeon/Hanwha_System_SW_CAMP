package com.ohgiraffers.section03.abstraction;

public class Car {

    private boolean isOn = false;
    private int speed;

    public void startUp() {

        if (isOn){
            System.out.println("이미 시동이 걸려있습니다.");
        }else {
            this.isOn = true;       // this 생략해도 자동으로 적힘
            System.out.println("시동을 걸었습니다.");
        }
    }


    public void go() {
        if (isOn){
            System.out.println("차가 앞으로 전진합니다.");
            speed += 10;
            System.out.println("현재 차량의 속도는 " + speed + "km/h 입니다.");
        }else {
            System.out.println("시동이 꺼져있어 달릴 수 없습니다.");
        }

    }

    public void stop() {
        if (isOn) {
            if (speed > 0){
                speed = 0;
                System.out.println("급 브레이크를 밟았습니다. 차를 멈춥니다.");
            }else {
                System.out.println("차는 이미 멈춰있는 상태입니다.");
            }
        }else {
            System.out.println("차의 시동이 걸려있지 않습니다. 시동을 먼저 걸어주세요.");
        }
    }

    public void turnOff() {
        if (isOn) {
            if (speed > 0){
                System.out.println("달리는 상태에서 시동을 끌 수 없습니다.");
            }else {
                isOn = false;
                System.out.println("차의 시동을 끕니다.");
            }
        } else {
            System.out.println("차의 시동이 이미 꺼져있습니다.");
        }
    }
}
