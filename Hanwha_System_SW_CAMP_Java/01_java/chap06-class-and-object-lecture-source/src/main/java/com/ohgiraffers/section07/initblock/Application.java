package com.ohgiraffers.section07.initblock;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 초기화 블럭의 동작 순서를 이해하고 이를 활용하여 인스탄스를 생성할 수 있다. */
        Product product = new Product();
        Product product2 = new Product("샤오미");

        System.out.println(product);
        System.out.println(product2.toString());



    }
}
