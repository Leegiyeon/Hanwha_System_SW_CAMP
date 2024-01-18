package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void eat(){
        System.out.println("호랑이가 고기를 뜯어 먹습니다.");
    }

    @Override
    public void run(){
        System.out.println("호랑이가 원만해서 달리지 않습니다.");
    }

    public void cry(){
        System.out.println("호랑이가 울부짖습니다. 어흥!");
    }
    public void bite() {
        System.out.println("호랑이가 물어뜯습니다. 앙");
    }



}
