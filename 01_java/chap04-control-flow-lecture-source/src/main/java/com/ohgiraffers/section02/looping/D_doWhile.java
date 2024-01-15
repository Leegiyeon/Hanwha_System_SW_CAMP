package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class D_doWhile {
    public void testSimpleDoWhileStatement() {

        do {
            System.out.println("실행..");
        } while (false);

        System.out.println("종료");


    }

    public void testDoWhileExample() {

        Scanner sc = new Scanner(System.in);
        String str = "";

        do {
            System.out.println("finish 입력 바랍니다.");
            str = sc.nextLine();

        } while (!str.equals("finish"));    //equals 메소드는 String비교에 사용 '=='와 같음

        System.out.println("종료");
    }
}
