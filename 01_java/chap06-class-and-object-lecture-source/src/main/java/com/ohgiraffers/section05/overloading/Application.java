package com.ohgiraffers.section05.overloading;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        Parameter pt = new Parameter();

        /* 목차. 1. 기본자료형을 매개변수로 전달 받는 메소드 호출 */
        int num = 20;
        System.out.println("Before call by value: "+ num);
        pt.testPrimitiveTypeParameter(num);                     // call by value(리터럴 값)
        System.out.println("After call by value: " + num);

        /* 목차. 2. 기본자료형 배열을 매개변수로 전달 받는 메소드 호출 */
        int[] iArr = new int[]{1, 2, 3, 4, 5};
        System.out.println("Before call by reference: "+ Arrays.toString(iArr));
        pt.testPrimitiveTypeParameter(iArr);                    // call by reference(참조 값)
        System.out.println("After call by reference: "+ Arrays.toString(iArr));

        /* 목차. 3. 클래스 자료형을 매개변수로 전달 받는 메소드 호출 */
        Rectangle r1 = new Rectangle(12.5,22.5);
//        r1.calArea();
//        r1.calRound();

        pt.testClassParameter(r1);

        /* 목차. 4. 아직 클래스 배열은 배우지 않았으므로 Pass */


        /* 목차. 5. 가변인자를 매개변수로 전달받는 메소드 호출 */
        pt.testVariableLengthArrayParameter();
        pt.testVariableLengthArrayParameter("홍길동");
        pt.testVariableLengthArrayParameter("유관순", "볼링");
        pt.testVariableLengthArrayParameter("강감찬", "낚시", "볼링");





    }

}
