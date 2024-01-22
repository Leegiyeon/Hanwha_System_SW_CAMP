package com.ohgiraffers.section01.generic;

/* 필기. 제네릭 클래스의 다이아몬드 연산자는 4가지 타입이 있다.(E: Element,T: Type,K: Key,V: Value) */
public class GenericTest<T> {

    /* 설명. 필드 및 메소들의 매개변수와 반환형의 자료형은 정해져 있지 않다. */
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
