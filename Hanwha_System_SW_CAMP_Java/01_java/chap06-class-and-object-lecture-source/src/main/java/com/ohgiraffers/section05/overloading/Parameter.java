package com.ohgiraffers.section05.overloading;

import java.util.Arrays;

/* 설명. 파라미터 타입별 호출 테스트 기능 제공용 클래스 */
public class Parameter {
    public void testPrimitiveTypeParameter(int num){
        num = 10;
        System.out.println("매개변수로 전달 받은 값: " + num);
    }

    public void testPrimitiveTypeParameter(int[] iArr){
        iArr[0] = 100;
        System.out.println("매개변수로 전달 받은 값: " + Arrays.toString(iArr));

    }

    public void testClassParameter(Rectangle ractangle) {

        /* 설명. 전달받은 사각형 객체의 넓이와 둘레 출력 */
        System.out.println("===== 변경 전 사각형 넓이/둘레 =====");
        ractangle.calArea();
        ractangle.calRound();

        /* 설명. 전달받은 사각형 객체의 너비와 높이를 변경 */
        ractangle.setWidth(20);
        ractangle.setHeight(40);


        /* 설명. 변경 후 사각형 객체의 넓이와 둘레 출력 */
        System.out.println("===== 변경 후 사각형 넓이/둘레 =====");
        ractangle.calArea();
        ractangle.calRound();
    }

    public void testVariableLengthArrayParameter(String... str) {       // Memo. 사용하지 않기를 권장
        System.out.println(Arrays.toString(str));
    }
}
