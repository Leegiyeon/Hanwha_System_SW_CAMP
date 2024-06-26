package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) throws RuntimeException {

        /* 수업목표. multi-catch 구문을 이해하고 활용할 수 있다. */
        ExceptionTest2 et = new ExceptionTest2();
        try {
            et.checkEnoughMoney(20000, 50000);
        } catch (PriceNegativeException | NotEnoughMoneyException | MoneyNegativeException e) {
            System.out.println("세개의 예외 처리:" + e.getMessage());

            /* 필기.
             *  예외 클래스, 예외 발생경로, 예외 메시지 등을 stack 호출 역순으로
             *  빨간 글씨의 로그형태로 출력해주는 기능
            * */
            e.printStackTrace();
        } finally {
            System.out.println("반드시 실행되는 finally 내용");
        }
        System.out.println("프로그램 종료");

        /* 필기.
         *  catch 블럭이 많을 때에는 위에서 아래로 예외타입을 확인하게되며,
         *  부모타입에 해당하는 예외처리는 아래쪽으로 작성해야한다.
        * */
    }
}
