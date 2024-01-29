package com.ohgiraffers.section01.intro;

public class OuterCalculator {
    public interface Sum {
        int sumTwoNumber(int a, int b);
    }


    public interface Minus {
        int minusTwoNumber(int a, int b);
    }


    public interface Mul {
        int mulTwoNumber(int a, int b);
    }


    public interface Div {
        int divTwoNumber(int a, int b);
    }


}
