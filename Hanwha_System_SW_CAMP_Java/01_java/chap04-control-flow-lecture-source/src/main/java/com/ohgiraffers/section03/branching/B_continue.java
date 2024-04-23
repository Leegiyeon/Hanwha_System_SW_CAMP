package com.ohgiraffers.section03.branching;

public class B_continue {
    public void testsimpleContinueStatement() {
        /* 수업목표. continue문 사용 */

        // 설명. 4의 배수이자 5의 배수 출력

        for (int i = 0; i < 101; i++){
            if(!(i%4 == 0 && i%5 ==0)) continue;
            System.out.println(i);
        }
    }
}
