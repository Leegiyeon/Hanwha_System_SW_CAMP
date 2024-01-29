package com.ohgiraffers.section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {

    /* 수업목표. Junit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */

    /* 필기. 해당 테스트를 무시할 때 사용 */
    @Disabled
    @Test
    public void testIgnore() {}


    /* 필기. 주어진 시간 안에 테스트가 끝나지 않으면 테스트가 실패한다. */
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(900);
//        Thread.sleep(1001);   // 예외 발생
    }

    @Test
    @Order(1)
    public void testFirst(){
        System.out.println("first");
    }

    @Test
    @Order(3)
    public void testThird(){
        System.out.println("third");
    }

    @Test
    @Order(2)
    public void testSecond(){
        System.out.println("second");
    }

    @RepeatedTest(10)
    public void testRepeat(){

    }

}
