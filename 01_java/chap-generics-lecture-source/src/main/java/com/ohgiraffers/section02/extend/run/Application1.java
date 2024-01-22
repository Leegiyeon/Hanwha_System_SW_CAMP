package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application1 {
    public static void main(String[] args) {
       /* 수업목표. extends 키워드를 사용하여 특정타입만 제네릭타입으로 사용하도록 제한할 수 있다. */

        /* 설명. Rabbit이거나 Rabbit의 자식타입이 아닌 타입으로 제네릭 타입을 지정하면 컴파일 에러 발생 */
//        RabbitFarm<Animal> farm1 = new RabbitFarm<Animal>();
//        RabbitFarm<Snake> farm2 = new RabbitFarm<Snake>();

        /* 설명. Rabbit이거나 Rabbit의 자식타입으로 인스턴스 생성 가능 */
        RabbitFarm<Rabbit> farm3 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm4 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm5 = new RabbitFarm<>();

        farm3.setAnimal(new Rabbit());
        farm3.getAnimal().cry();
        farm3.setAnimal(new Bunny());
        farm3.getAnimal().cry();        // 동적 바인딩에 의해 반환형인 Animal의 cry가 아닌 Bunny의 cry가 실행

        farm4.setAnimal(new Bunny());
        farm4.getAnimal().cry();

        farm5.setAnimal(new DrunkenBunny());
        farm5.getAnimal().cry();
    }
}
