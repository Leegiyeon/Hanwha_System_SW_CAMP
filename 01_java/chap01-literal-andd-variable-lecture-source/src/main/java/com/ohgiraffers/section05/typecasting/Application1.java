package com.ohgiraffers.section05.typecasting;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 자동 형변환(implicit coercion) 규칙에 대해 이해할 수 있다. */

        /* 설명. 점점 더 큰 자료형으로 데이터를 옮겨도 문제없이 자동형 변환되어 대입이 이루어진다. */
        byte bnum = 1;              //리터럴이 정수일때 자바는 int로 받아들이지만 in -> byte, int -> short는 자동 형 변환됨
        short snum = bnum;
        int inum = snum;
        long lnun = inum;


        /* 설명. 연산 시에도 자동으로 큰 쪽 자료형에 맞춰서 낮은 자료형이 자동형 변환된다. */
        int num1 = 10;
        long num2 = 20L;

        long result1 = num1 + num2;
        System.out.println("result1 = " +result1);

        /* 설명. 문자형은 int형으로 자동 형변환 된다.(반대도 가능함) */
        int ch1 = 'a';
        int charNumber = ch1;
        System.out.println("charNumber = "+ charNumber);

        char ch2 = 65;
        System.out.println("ch2 = "+ ch2);
    }
}
