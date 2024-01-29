package com.ohgiraffers.section01.intro;

import org.w3c.dom.ls.LSOutput;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 람다식에 대해 이해하고 활용할 수 있다. */

        /* 필기. 1. 인터페이스를 구현한 구현체를 이용한 방식(동적바인딩 적용) */
        Calculator c1 = new CalculatorImpl();
        System.out.println("10과 20의 합 = " + c1.sumToNumber(10, 20));


        /* 필기. 2. 익명클래스를 활용한 방식(하위 구현체) */
        Calculator c2 = new Calculator() {
            @Override
            public int sumToNumber(int num1, int num2) {
                return (num1 * num2) * 2;
            }

        };
        System.out.println("10과 20의 합 곱하기 2 = " + c2.sumToNumber(10, 20));


        /* 핅기. 3. 람다식 */
//        Calculator c3 = (x,y) -> {return (x+y) * 3;};
        Calculator c3 = (x,y) -> (x+y) * 3;
        System.out.println("10과 20의 합 곱하기 3 = " + c3.sumToNumber(10,20));
    }
}
