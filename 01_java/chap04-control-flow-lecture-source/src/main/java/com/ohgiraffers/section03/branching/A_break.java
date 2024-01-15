package com.ohgiraffers.section03.branching;

import java.util.Scanner;

public class A_break {
    public void testSimpleBreakStatement() {

        /* 수업목표. break문 사용 */
        /* 필기. break문은 반복문안에 사용됨*/
        
        int sum = 0;
        int i = 1;

        while (true){
            sum += i;
            System.out.println("sum = " + sum);

            if(i == 10) break;

            i++;
        }
    }

    public void testPrintStarsWithBreakStatement() {
//        설명. 양의 정수 입력: 5
//        *
//        **
//        ***
//        ****
//        *****
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = 0; i < input+1; i++){
            for (int j = 0; j < input; j++){
                System.out.print('*');
                if(j==i) break;
            }
            System.out.println();
        }

    }
}
