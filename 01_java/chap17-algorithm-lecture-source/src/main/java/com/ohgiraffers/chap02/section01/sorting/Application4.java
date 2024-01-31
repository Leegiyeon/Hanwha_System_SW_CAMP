package com.ohgiraffers.chap02.section01.sorting;

import java.util.Scanner;

public class Application4 {

    /* 수업목표. 퀵 정렬*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        solution(0, arr.length - 1, arr);

        for (int i: arr) {
            System.out.printf(i + " ");;
        }


    }

    static void solution(int lo, int hi, int[] arr) {
        if (lo >= hi) {
            return;
        }

        System.out.println("==== Before Process ====");;
        int pivot = process(lo, hi, arr);
        System.out.println("lo = " + lo + ", hi = " + hi + ", pivot = " + pivot);
        System.out.println("==== After Process ====");

        solution(lo, pivot, arr);
        solution(pivot + 1, hi, arr);
    }

    /* 설명. lo에 해당하는 포인터와 hi에 해당하는 포인터를 최대한 움직여 pivot을 반환하는 메소드 */
    private static int process(int left, int right, int[] arr) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left+right) / 2];
        while (true) {
            /* 설명. pivot 위치에 있는 값보다 작은 값을 가리키면 lo 포인터를 증가 */
            do {
                lo++;
            } while (arr[lo] < pivot);
            /* 설명. pivot 위치에 있는 값보다 크면서 lo 포인터의 위치보다 크거나 같은 위치이면 감소 */
            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);
            /* 설명. lo 포인터의 위치가 hi 포인터를 앞지르려고 하면 hi 위치를 반환(분할 기준 반환) */
            if (lo >= hi) {
                return hi;
            }
            swap(arr, lo, hi);
        }
    }

    /* 설명. 전달된 배열과 인텍스들을 바탕으로 위치를 스왑(바꾸는) 메소드 */
    private static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr [hi];
        arr[hi] = temp;
    }
}
