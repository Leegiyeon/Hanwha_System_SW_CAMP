package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다. */
        /* 설명.
         * static이 붙어있지 않은 메소드는 <클래스명 변수명 = new 클래스명();>을 활용해 메소드를 호출해야한다.
         * (접근연산자(.)도 활용)
         * */

        System.out.println("main() 시작됨...");

        Application2 app2 = new Application2();
        app2.methodA();

        methodB();
        methodC();

        System.out.println("main() 종료됨...");
    }

    public void methodA(){
        System.out.println("methodA 호출됨...");
        System.out.println("methodA 종료됨...");
    }

    public static void methodB(){
        System.out.println("methodB 호출됨...");
        System.out.println("methodB 종료됨...");
    }

    public static void methodC(){
        System.out.println("methodC 호출됨...");
        System.out.println("methodC 종료됨...");
    }
}
