package com.ohgiraffers.section06.singleton;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 싱글톤 패턴에 대해 이해하고 이를 구현할 수 있다. */
        /* 필기.
         *  singleton pattern이란
         *   애플리케이션이 시작될 때, 어떤 클래스가 최초 한번만 메모리에 할당되고 그 메모리에
         *   인스턴스가 하나만 생성되어 공유되게 하는 것
         *   (메모리 낭비 방지)
         *
         * 필기.
         *  장점
         *   1. 첫 번째 이용 시, 인스턴스를 생성해야하므로 속도차이가 나지 않지만
         *      두 번째 이용 시, 인스턴스 생성시간 없이 바로 사용 가능(재사용)
         *   2. 인스턴스가 절대적으로 한 개만 추구하는 것을 보증할 수 있다.
         *  단점
         *   1. 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유하면 결합도가 높아짐
         *   2. 동시성 문제를 고려해서 설계해야하기에 난이도가 높다.
         *
         * 필기.
         *  싱글톤 구현방법
         *   1. 이른 초기화(Eager Initialization)
         *   2. 늦은 초기화(Lazy Initialization)
        * */

        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("eager1의 주소: " + eager1.hashCode());
        System.out.println("eager2의 주소: " + eager2.hashCode());


        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("lazy1의 주소: " + lazy1.hashCode());
        System.out.println("lazy2의 주소: " + lazy2.hashCode());

        /* 필기.
         *  이른 초기화를 사용하면 클래스를 로드하는 속도가 느려지지만
         *  처음 인스턴스 반환 요청에서 속도가 빠르다는 장점을 가진다.
         *  반면 늦은 초기화는 클래스를 로드하는 속도는 빠르지만 첫 번째 요청에 대한 속도가
         *  두 번째 요청에 대한 속도보다 느리다는 특징을 가지고 있다.
        * */

    }
}
