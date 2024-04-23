package com.ohgiraffers.section01.polymorphism;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 다형성과 타입 형 변환에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();

        /* 설명. 다형성 적용(부모타입으로 자식 인스턴스의 주소값 저장) */
        Animal an1 = new Tiger();
        Animal an2 = new Rabbit();
        Animal an3 = new Animal();          // 다형성 아님

        /* 설명. Animal은 Tiger나 Rabbit이 아니다.(Animal은 Tiger나 Rabbit 타입을 지니고 있지 않다.) */
//        Tiger t1 = new Animal();
//        Rabbit r1 = new Animal();

        /* 설명. 동적 바인딩 확인 */
        /* 필기.
         *  컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가,
         *  런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩이 바뀌어 동작하는 것을 의미한다.
         *  (조건. 상속, 오버라이딩)
         * */
        System.out.println("======동적바인딩 확인=======");
        an1.cry();          // Memo. 'an1' 만 입력시까지 Animal로 인식(정적 바인딩 상태)
        an2.cry();          // Memo. 따라서 an1.bite()  an2.jump()를 입력할 수 없음
        an3.cry();          // Memo. 정적 바인딩 -> 동적 바인딩 (상속과 오버라이딩이 된 상태)
                            // Memo. 실행하려고 보니, 어? 내자식것도 있네 그럼 내 자식 먼저 실행하자

        /* 설명. 오버라이딩 되지 않은(추가한) 메소드 호출은 다운 캐스팅(형 변환) 해주어야 한다. */
        /* 필기.
         *  instanceof란?
         *   해당 객체의 타입을 런타임 시점에 확인하기 위한 연산자
        * */
        if (an1 instanceof Tiger) { // an1은 Tiger타입의 instance이다 T/F
            ((Tiger) an1).bite();
        }
        if (an1 instanceof Rabbit) {
            ((Rabbit) an1).jump(); // Memo. 실행하면 an1은 Rabbit이 아닌 Tiger이므로 에러발생
        }
        ((Rabbit) an2).jump();

        /* 설명. 다형성은 상속관계의 객체들간의 형 변환 */
        Animal animal2 = new Tiger();       // Memo. 자동 형 변환(다형성), 묵시적 형 변환
        Rabbit rabbit2 = (Rabbit)an2;       // Memo. 강제 형 변환(다형성 X), 명시적 형 변환

    }
}
