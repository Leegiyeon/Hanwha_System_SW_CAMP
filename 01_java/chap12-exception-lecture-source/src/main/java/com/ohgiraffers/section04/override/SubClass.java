package com.ohgiraffers.section04.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {
    /* Memo. 부모의 메소드와 같은 예외발생(Pass) */
//    @Override
//    public void method() throws IOException {
//
//    }

    /* Memo. 부모의 메소드와 달리 예외를 발생시키지 않음(Pass) */
//    @Override
//    public void method() {
//
//    }

    /* Memo. 부모의 메소드보다 하위 타입의 예외 발생(Pass) */
//    @Override
//    public void method() throws FileNotFoundException {
//
//    }
    /* Memo. 더 큰 범주의 Exception 발생 시, catch가 어려움 (다형성) - Fail */
//    @Override
//    public void method() throws Exception {
//
//    }

}
