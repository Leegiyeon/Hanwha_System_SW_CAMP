package com.ohgiraffers.section02.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표, 표준함수적 인터페이스 중 Operator에 대해 이해하고 사용할 수 있다. */
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("hello, ", "world!"));

        UnaryOperator<String> unaryOperator = str -> str;
        System.out.println(unaryOperator.apply("hello2, "));

    }
}
