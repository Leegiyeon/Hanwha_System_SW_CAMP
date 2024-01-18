package com.ohgiraffers.section01.polymorphism;

public class Application4 {

    public static void main(String[] args) {
        /* 수업목표. 다형성을 적용하여 리턴타입에 적용할 수 있다. */
        Application4 app4 = new Application4();
        Animal randomAnimal = app4.getRandomAnimal();
        randomAnimal.cry();
    }

    private Animal getRandomAnimal(){
        int rand = (int) (Math.random()*2);     // 0 또는 1
        return rand == 0 ? new Tiger() : new Rabbit();
    }
}
