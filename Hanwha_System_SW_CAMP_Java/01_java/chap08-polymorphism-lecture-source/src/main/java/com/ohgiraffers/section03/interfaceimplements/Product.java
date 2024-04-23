package com.ohgiraffers.section03.interfaceimplements;

import java.io.Serializable;

/* 설명. 인터페이스간에는 다중 상속이 가능하고 implements 대신 extends를 사용한다. */
public class Product implements InterProduct, Serializable { // Memo. 인터페이스는 다중 구현(다중 상속개념)이 가능하다.
                                                            // 구현한다. = implement

    @Override
    public void nonStaticMethod() {
        System.out.println("InterProduct의 nonStaticMethod 오버라이딩 메소드 호출됨...");
    }

    public void defaultMethod(){        // 오버라이딩 시에는 default 예약어 제거
        System.out.println("Product 클래스에서 인터페이스로부터 물려받은 defaultMethod 호출됨...");
    }
}
