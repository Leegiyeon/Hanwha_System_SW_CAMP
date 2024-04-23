package com.ohgiraffers.chap02.section01.sorting;

public class Application5 {

    /* 수업목표. 병합 정렬*/
    /* 필기.
     *  병합 정렬 O(nlog n)
     *   데이터를 분할하고 분할한 집합을 정렬하여 병합하는 방식을 반복하여 정렬 */

    public static void solution(int low, int high, int[] arr) {

        int[] temp = new int[high + 1];


        if (high - low == 0) {
            return;
        }

        int median = low + (high - low) / 2;

        solution(low, median, arr);
        solution(median + 1, high, arr);

        /* 설명. 정렬 전 temp 에 배열 복사 */
        temp = arr.clone();

        /* 설명. 분할 정복 방식으로 작은 값부터 값을 쌓음 */
        int k = low;
        int index1 = low;
        int index2 = median + 1;

        /* 설명. 두 인데스가 가리키는 값들을 비교 후 하나라도 분할 구역의 끝을 만나면 멈추는 반복문 */
        while (index1 <= median && index2 <= high) {
            if (temp[index1] < temp[index2]) {      // 내림차순
//            if (temp[index1] > temp[index2]) {    // 오름차순
                arr[k] = temp[index2];
                k++;
                index2++;
            } else {
                arr[k] = temp[index1];
                k++;
                index1++;
            }
        }

        /* 설명. 좌측 인덱스 마저 옮기기 */
        while (index1 <= median) {
            arr[k] = temp[index1];
            k++;
            index1++;
        }

        /* 설명. dn측 인덱스 마저 옮기기 */
        while (index2 <= high) {
            arr[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
