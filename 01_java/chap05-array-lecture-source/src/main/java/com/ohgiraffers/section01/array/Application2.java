package com.ohgiraffers.section01.array;

public class Application2 {
    public static void main(String[] args) {

        int[] iArr;
//        char cArr[];      // 대괄호를 변수명 뒤에 붙여도 되지만 권장하지 않음
        iArr = new int[10]; // 크기를 할당해주어야 함

        char[] cArr = new char[5];

        System.out.println("iArr = " + iArr);
        System.out.println("iArr = " + iArr.hashCode()); // hashcode를 통해 10진수 주소값 확인
        System.out.println("cArr = " + cArr);
        System.out.println("cArr = " + cArr.hashCode());

        cArr = null;
        System.out.println("null참조 시: " + cArr.hashCode()); // null값을 지닌 참조자료형 변수에 잡근시 에러발생



    }
}
