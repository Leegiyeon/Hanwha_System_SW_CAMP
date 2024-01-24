package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception {
        System.out.println("가지고 계신 금액: " + money + "원 입니다.");

        if (money >= price) {
            System.out.println(price + "원 상품을 구입하기 위한 금액이 충분합니다.");
        } else {
            throw new Exception("호주머니 사정이 어려우시네요..");      // Memo. 여기서 try catch 사용 X
        }
    }
}


