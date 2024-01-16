package com.ohgiraffers.section01.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application3 {

    public static void main(String[] args) {
        /* 수업목표. 배열에 초기화 되는 자료형별 기본값 */
        /* 필기
         * 값의 형태별 기본값
         * 정수: 0
         * 실수: 0,0
         * 논리: false
         * 문자: \u0000
         * 참조: null
         */

        int[] iArr = new int[5];
        System.out.println(Arrays.toString(iArr));

        boolean[] bArr = new boolean[6];
        System.out.println(Arrays.toString(bArr));

        int[] iArr2 = {10, 11, 12, 13, 14};             // 크기 및 초기값 일괄적용(축약)
        int[] iArr3 = new int[]{10, 11, 12, 13, 14};

        String[] sArr = {"apple", "banana", "grape", "orange"};

        // 1차원 배열 출력(for)
        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }

        // 1차원 배열 출력(Arrays.toString())
        System.out.println(Arrays.toString(sArr));

        // // 1차원 배열 출력(for-each) 향상된 for문
        for (String str : sArr){
            System.out.println(str);
        }
    }

}
