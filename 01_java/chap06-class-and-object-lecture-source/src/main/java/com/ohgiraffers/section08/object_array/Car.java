package com.ohgiraffers.section08.object_array;

public class Car {
    private String modelName;
    private int maxSpeed;

    public Car() {
    }

    public Car(String modelName, int maxSpeed){

        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    public void DriveMaxSpeed(){
        System.out.println(modelName + "차량의 최고속도는 " + maxSpeed + "km/h 입니다.");
    }
}
