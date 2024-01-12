package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Application6;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        com.ohgiraffers.section01.method.Calculator cal = new com.ohgiraffers.section01.method.Calculator();

        /* 목차. 1. non-static 메소드 호출 */
       int plusResult =  cal.plusTwoNums(100,20);
        System.out.println("100과 20의 합: "+ plusResult);

        /* 목차. 2. static 메소드 호출 */
        int maxResult = com.ohgiraffers.section01.method.Calculator.maxTwoNums(100,20);
        System.out.println("두 수 중 큰 값: " + maxResult);
    }
}
