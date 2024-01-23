package com.ohgiraffers.section01.generic;

public class Application {

    public static void main(String[] args) {
        /* 수업목표. 제네릭에 대해 이해할 수 있다. */

//        GenericTest<Integer> gt1 = new GenericTest<Integer>();
        GenericTest<Integer> gt2 = new GenericTest<>();         // 다이아몬드 연산자 생략 가능

        gt2.setValue(1);
        System.out.println(gt2.getValue());
        System.out.println(gt2.getValue() instanceof Integer);


        GenericTest<String> gt3 = new GenericTest<>();         // 다이아몬드 연산자 생략 가능

        gt3.setValue("피카츄");
        System.out.println(gt3.getValue());
        System.out.println(gt3.getValue() instanceof String);
    }
}
