package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Scanner를 이용한 다양한 자료형 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 목차. 1. 문자열 입력받기 */
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();                        // 공백이나 개행을 포함한 한 줄의 문자열 모두 반환
        System.out.println("입력하신 이름은: " + name);

        /* 목차. 2. 정수형 입력받기 */
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("입력하신 나이는: " + age);

        /* 목차. 3. 실수형 입력받기 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("입력하신 키는: " + height);

        /* 목차. 4. 논리형 입력받기 */
        System.out.print("True or False: ");
        boolean isTrue = sc.nextBoolean();
        System.out.println("입력하신 논리 값은: " + isTrue);

        /* 목차. 5. 문자형 입력받기 */
        System.out.print("문자를 입력하세요: ");
//        sc.nextLine(); // 중간에 버퍼에 남은 공백 및 개행 제거용 >> nextLine() 사용 시 주석 제거
        char ch = sc.next().charAt(0);              // next()는 공백이나 개행 전까지 문자열 반환
        // charArt(index)
        System.out.println("입력하신 문자는: " + ch);

    }
}
