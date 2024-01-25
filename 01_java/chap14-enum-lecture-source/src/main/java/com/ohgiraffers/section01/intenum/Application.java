package com.ohgiraffers.section01.intenum;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 정수 열거 패턴과 이의 단점을 이해할 수 있다. */
        int subject1 = Subjects.JAVA;
        int subject2 = Subjects.HTML;

        /* 설명. 1. 둘다 상수이자 숫자일 뿐, 같은 숫자일 경우 구분할 수 없다. */
        if(subject1 == subject2){
            System.out.println("두과목은 같은 과목이다.");
        }

        /* 설명. 2. 이름 충돌 방지를 위해서 접두어를 써서 구분한다.(이름, 번호가 같은 경우)*/
        /* 설명. 3. 변수명에 쓰인 이름/문자열을 출력하기 어렵다. */
        Scanner sc = new Scanner(System.in);
        System.out.print("0~2사이의 과목명 입력: ");
        int filedNo = sc.nextInt();

        String subName = "";
        switch (filedNo){
            case Subjects.JAVA : subName = "JAVA"; break;
            case Subjects.MARIADB : subName = "MARIADB"; break;
            case Subjects.JDBC : subName = "JDBC"; break;
        }

        System.out.println("선택한 과목명: " + subName);

        /* 설명. 4. 같은 클래스에 속한 상수를 반복해서 조회할 수 없다. (전체 필드 갯수도 알 수 없다.)*/

        /* 설명. 5. 타입 안전성을 보장할 수 없다. (Subjects.JAVA라는 것과 정수값이 구분되지 않음)*/
        printSubject(Subjects.JAVA);
        printSubject(0);        // 아무런 int 값이나 전달되어도 해당 매소드는 문제없이 동작한다.

    }

    private static void printSubject(int num) {
    }
}
