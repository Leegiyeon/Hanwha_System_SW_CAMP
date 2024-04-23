package com.ohgiraffers.section06.statickeyword;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. static 키워드에 대해 이해할 수 있다. */
        /* 필기.
         *  static
         *   : 프로그램이 실행될 때, 정적 메모리 영역에 할당하는 키워드
         *     여러 인스턴스가 공유해서 사용할 목적으로 형성한 공간
         *     대표적인 예로 singleton 객체가 있다.
        * */

        /* 목차. 1. static 키워드를 필드에서 사용 */
        StaticFieldTest stf1 = new StaticFieldTest();


        /* 설명. 현재 두 필드가 가지고 있는 값 확인 */
        System.out.println("non-static field: " + stf1.getNonStaticCount());
        System.out.println("static field: " + StaticFieldTest.getStaticCount());

        /* 설명. 각 필드 값 증가 */
        stf1.increaseNonstaticCount();
        StaticFieldTest.increaseStaticCount();

        /* 설명. 두 필드 값 확인 */
        System.out.println("non-static field: " + stf1.getNonStaticCount());
        System.out.println("static field: " + StaticFieldTest.getStaticCount());

        /* 설명. 새로운 객체 생서 */
        StaticFieldTest stf2 = new StaticFieldTest();
        System.out.println("non-static field: " + stf2.getNonStaticCount());
        System.out.println("static field: " + StaticFieldTest.getStaticCount());


    }
}
