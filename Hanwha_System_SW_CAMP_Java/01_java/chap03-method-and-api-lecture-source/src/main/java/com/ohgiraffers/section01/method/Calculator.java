package com.ohgiraffers.section01.method;

public class Calculator {
    public int plusTwoNums(int first, int second){
        return first + second;
    }

    public int subTwoNums(int first, int second){
        return first - second;
    }

    public int multiTwoNums(int first, int second){
        return first * second;
    }

    public int divideTwoNums(int first, int second){
        return first / second;
    }

    private int minTwoNums(int first, int second){
        return (first > second) ? second : first;
    }

    public static int maxTwoNums(int first, int second){
        return (first < second) ? first : second;
    }
}
