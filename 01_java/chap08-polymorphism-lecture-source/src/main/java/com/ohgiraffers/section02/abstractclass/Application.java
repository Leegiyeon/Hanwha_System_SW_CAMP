package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 추상클래스와 추상 메소드에 대해 이해할 수 있다. */
        /* Memo. 부모 클래스에서 추상 메소드 생성 > 객체 생성 불가(하나의 추상 메소드를 지니면 추상 클래스가 되어야함)
         *  자식클래스는 선택지가 두개(자식도 추상클래스가 된다. / 추상메소드를 온전하게 만든다.)
        * */
        /* 필기.
         *  추상클래스와 추상메소드
         *   추상클래스: 추상메소드를 0개 이상 포함하는 클래스(불완전한 클래스)
         *   불완전한 클래스는 생성자를 통해 객체 생성이 불가
         *   (단, 자식 클래스가 객체 생성될때는 내부적으로 가능)
         * 필기.
         *   추상메소드: 메소드의 헤드부만 있고 바디부가 없는 메소드(불완전한 메소드)
         *   불완전한 메소드를 하나라도 가진 클래스는 반드시 추상 클래스가 되어야 함
         *   EX) public abstract void method();
         *
         *
        * */

        /* 설명. abstract 클래스는 객체를 생성할 수 없는 불완전한 클래스이다. */
//        Product product = new Product();

        /* 설명. abstract 메소드를 구현한 온전한 자식클래스는 인스턴스(객체)를 생성할 수 있다. */
        SmartPhone smartPhone = new SmartPhone();

        Product product = new SmartPhone();     // 다형성(polymorphism) 적용
        product.abstractMethod();               // 동적 바인딩에 의한 자식 클래스의 오버라이딩 메소드 실행
    }
}
