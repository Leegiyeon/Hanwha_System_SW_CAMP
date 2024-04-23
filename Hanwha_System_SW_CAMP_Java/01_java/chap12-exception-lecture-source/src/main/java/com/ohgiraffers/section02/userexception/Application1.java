package com.ohgiraffers.section02.userexception;


import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의의 예외 클래스 정의 후 발생한 사용자정의의 예외를 처리할 수 있다. */
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(10000, 50000);
        }
        catch (Exception e){
            System.out.println("예외 메시지: " + e.getMessage());
        }         // Memo. Exception 이 부모이므로 다형성에 의해 이하가 실행되지 않는다.
//        catch (PriceNegativeException | MoneyNegativeException | NotEnoughMoneyException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
