package com.ohgiraffers.section01.array;

import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {
        /* 수업목표. 배열을 사용하는 예시 이해 및 적용 */
        /* 필기. 5명의 Java 점수를 정수로 입력받아 합계 평균을 실수로 출력하는 프로그램 */

        int[] score = new int[5];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < score.length; i++) {
            System.out.print((i + 1) + "번째 학생의 점수를 입력해 주세요: ");
            score[i] = sc.nextInt();

        }

        //합계
        int sum = 0;
        for (int i = 0; i < score.length; i++) { // int perScore: score
            sum += score[i];                     // sum += perScore
        }

        //평균
        double avg = 0.0;
        avg = sum / (double)score.length;

        System.out.println("학생들의 점수 합계는 " + sum + "이고, 평균은 " + avg + "점 입니다.");
    }
}
