package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 배열에 대한 이해 */
        /* 필기.
         * 배열: 동일한 자료형을 묶음
        * */

        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int sum = 0;

        sum += num1;
        sum += num2;
        sum += num3;
        sum += num4;
        sum += num5;

        System.out.println("sum = " + sum);

        // 배열로 위 과정 실행
        int sum1 = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++){
            arr[i] = (i + 1) * 10;
        }

        System.out.println("배열의 길이: " + arr.length);
        for (int j = 0; j < arr.length; j++){
            sum1 += arr[j];
            System.out.println("arr[i] = " + arr.length);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("sum1 = " + sum1);

    }
}
