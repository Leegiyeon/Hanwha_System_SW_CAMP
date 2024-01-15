package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {
    public void testSimpleWhileStatement() {

        int i = 1;

        while (i < 11){
            System.out.println(i);
            i++;
        }
    }

    public void testWhileExample() {
        Scanner sc = new Scanner(System.in);
        char ch = '\u0000';

        while (ch != 'y'){
            System.out.print("y 입력하세요: ");
            ch = sc.next().charAt(0);
        }

        System.out.println("y 입력 감사합니다.");
    }
}
