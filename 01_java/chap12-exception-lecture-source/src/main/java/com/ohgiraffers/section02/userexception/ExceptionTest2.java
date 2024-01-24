package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest2 {

    public void checkEnoughMoney(int price, int money)
            throws PriceNegativeException, MoneyNegativeException, NotEnoughMoneyException {
//            throws Exception {          // Memo. 다형성

        /* 설명. throw 를 통한 예외발생 시, 바로 메소드를 호출한 곳으로 예외 인스턴스와 함께 반환된다. */
        if (price < 0) {
            throw new PriceNegativeException("상품가격은 음수일 수 없습니다.");
        }

        if (money < 0) {
            throw new MoneyNegativeException("돈은 음수일 수 없습니다.");
        }

        if (money < price) {
            throw new NotEnoughMoneyException("가진 돈이 부족합니다.");
        }

        System.out.println("상품 구입이 가능합니다.");
    }
}
