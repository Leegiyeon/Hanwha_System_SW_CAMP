package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("토끼가 먹이를 먹습니다. 옴뇸뇸..");
    }

    @Override
    public void run() {
        System.out.println("토끼가 뛰어갑니다. 총총총..");
    }

    @Override
    public void cry() {
        System.out.println("토끼가 낑낑대며 웁니다.");
    }

    public void jump(){
        System.out.println("토끼가 점프를 뜁니다. 껑~충");
    }
}
