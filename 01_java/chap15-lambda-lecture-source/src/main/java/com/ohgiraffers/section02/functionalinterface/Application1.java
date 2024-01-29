package com.ohgiraffers.section02.functionalinterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스 중 Consumer에 대해 이해할 수 있다. */
        /* 설명. 반환형 없는 메소드 관련 람다식 */
        /* 필기.
         *  JDK 8에서 자주 사용되는 함수적 인터페이스를 표준 API로 제공하고 있다.
         *  Consumer: 리턴값이 없는 accept()메소드를 지님
         *  Supplier: 매개변수가 없고 리턴 값이 있는 getXXX() 메소드를 지님
         *  Function: 매개변수와 리턴 값이 있는 applyXXX() 메소드를 지님
         *  Operator: Function과 같이 apply()메소드를 지님(반환형 타입 통일)
         *  Predicate: 매개변수와 boolean 값을 반환하는 testXXX()를 지님
        * */
        Consumer<String> consumer = str -> System.out.println(str + "이(가) 입력됨");
        consumer.accept("Hello?");

        BiConsumer<String, LocalTime> biConsumer = (str, time) -> System.out.println(str + "이(가) " + time + "에 입력됨");
        biConsumer.accept("Hello", LocalTime.now());

        ObjIntConsumer<Random> objIntConsumer = ((random, bound) -> System.out.println("0부터 " + bound + "까지 난수 발생 : "+ random.nextInt()));
        objIntConsumer.accept(new Random(), 10);
    }

}
