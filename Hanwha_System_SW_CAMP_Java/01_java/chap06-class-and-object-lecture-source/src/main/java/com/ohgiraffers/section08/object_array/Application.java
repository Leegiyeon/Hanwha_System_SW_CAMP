package com.ohgiraffers.section08.object_array;


public class Application {
    public static void main(String[] args) {

        /* 수업목표. 객체배열에 대해 이해할 수 있다. */
        Car car1 = new Car("Ferari", 360);
        Car car2 = new Car("Lamborgini", 450);
        Car car3 = new Car("Bugati", 500);
        Car car4 = new Car("Potter", 240);
        Car car5 = new Car("Tesla", 300);

//        car1.DriveMaxSpeed();
//        car2.DriveMaxSpeed();
//        car3.DriveMaxSpeed();
//        car4.DriveMaxSpeed();
//        car5.DriveMaxSpeed();


        Car[] carArr= new Car[5];
        carArr[0] = new Car("Ferari", 360);
        carArr[1] = new Car("Lamborgini", 450);
        carArr[2] = new Car("Bugati", 500);
        carArr[3] = new Car("Potter", 240);
        carArr[4] = new Car("Tesla", 300);

//        for (int i = 0; i < carArr.length; i++) {
//
//        }

        for (Car car: carArr) {
            car.DriveMaxSpeed();
        }


    }
}
