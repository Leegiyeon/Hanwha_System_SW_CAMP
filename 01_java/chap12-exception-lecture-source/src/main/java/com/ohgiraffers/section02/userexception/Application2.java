package com.ohgiraffers.section02.userexception;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. finally 를 활용한 try-catch 문 이해하고 활용하기  */
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(-10000, 50000);
        } catch (Exception e) {
            System.out.println("충분한 돈을 지녔는지 유효성 체크 결과 문제: " + e.getMessage());
        } finally {
            /* 설명. try 구문에서 예외가 발생하는 것과 관계없이 반드시 실행해야 하는 부분을 작성하는 곳 */
            System.out.println("finally 블럭의 내용이 동작...");
        }

        System.out.println("프로그램 종료");
    }
}
