package com.ohgiraffers.chap02.section01.sorting;

import java.util.Arrays;
import java.util.Scanner;

/* 수업목표. 선택 정렬*/
/* 필기.
 *  선택 정렬 O(n^2)
 *   대상 데이터에서 최대나 최소 데이터를 찾아 맨 앞과 교환하는 방법이다.
 *   배열의 모든요소에 대해 반복한다.
 * */
public class Application2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        /* 설명. 입력 데이터 받기 */
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();          // 공백을 구분자로 숫자 입력 받음
        }

        /* 설명. 알고리즘 실행 */
        solution(length, arr);

        /* 설명. 정렬 결과 출력 */
        for (int i : arr) {
            System.out.print(i + " ");;
        }
    }

    private static void solution(int length, int[] arr) {

//        for (int i = 0; i < length; i++) {
//            System.out.println("arr: " + Arrays.toString(arr));
//            int maxIndex = i;
//
//            for (int j = i; j < length; j++) {
//                if(arr[i] > arr[j]){
//                    maxIndex = j;
//                    int temp = arr[i];
//                    arr[i] = arr[maxIndex];
//                    arr[maxIndex] = temp;
//                }
//            }
//        }

        for (int i = 0; i < length - 1; i++) {
            System.out.println("arr: " + Arrays.toString(arr));
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if(arr[i] > arr[j]){
                    minIndex = j;
                    int temp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
    }

}
