package com.ohgiraffers.section01.array;

import java.util.Random;

public class Application5 {

    public static void main(String[] args) {
        /* 수업목표. 배열 사용 예시 */

        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] cardNum = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

        int randShape;          // 0-3
        int randCardNum;        // 0-11

        randShape = (int)Math.random() * 4;
        randCardNum = new Random().nextInt(13);

        System.out.println("당신이 뽑은 카드는 \"" + shape[randShape] + " " + cardNum[randCardNum] + "\"카드입니다.");

    }
}
