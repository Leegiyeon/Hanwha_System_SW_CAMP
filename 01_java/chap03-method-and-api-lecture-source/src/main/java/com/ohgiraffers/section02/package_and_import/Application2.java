package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator; // 설명. import는 경로를 생략하기 위해 작성 (줄여 쓰기 위함)
public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. import에 대해 이해할 수 있다. */

        /* 목차. 1. non-static method */
        Calculator cal = new Calculator(); // import를 활용해 줄여쓴 Calculator
        int first = 100;
        int second = 200;
        int sub = cal.subTwoNums(first, second);

        System.out.println("두 수의 합: " + cal.plusTwoNums(first, second));
        System.out.println("두 수의 차: " + sub);

        /* 목차. 2. static method */
        System.out.println("두 수 중 큰 값: " + Calculator.maxTwoNums(first, second));
    }
}
