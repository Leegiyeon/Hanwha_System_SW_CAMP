package com.ohgiraffers.section02.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 표준함수적 인터페이스 증 Function에 대해 이해하고 사용할 수 있다. */
        Function<String, Integer> function = str -> Integer.parseInt(str);
        String strValue = "123456";
        System.out.println(function.apply(strValue));

        BiFunction<String, String, Integer> biFunction = (str1, str2) -> Integer.valueOf(str1) +  Integer.valueOf(str2);
        System.out.println(biFunction.apply("12345", "111111"));

    }
}
