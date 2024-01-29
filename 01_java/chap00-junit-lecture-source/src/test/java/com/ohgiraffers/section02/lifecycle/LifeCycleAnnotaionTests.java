package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifeCycleAnnotaionTests {

    /* 수업목표. 테스트 메소드의 실행 전 후에 동작하는 어노테이션을 사용할 수 있다. */
    /* 설명.
     *  모든 테스트 메소드와 라이프 사이클 관련 메소드는 abstract(추상)이 면 안되고, void반환형으로 작성해야한다.
     *  또한 접근 제어자는 사용하지 않아도 되지만(defauit), private이면 안된다.
    * */

    /* 설명. 테스트 실앵 전 한 번만 실행 */
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    /* 설명. 각각의 테스트 메소드가 실행되기 전 실행(주로 테스트 전에 필요한 목업 데이터를 미리 세팅해 줄 목적으로 사용된다. */
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @Test
    public void test1(){
        System.out.println("test1");

    }

    @Test
    public void test2(){
        System.out.println("test2");
    }


    /* 설명. 각각의 테스트 메소드가 동작한 직후 동작(주로 단위 테스트들이 수정된 이후 사용한 자원을 반납/해제할 목적으로 사용된다.) */
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    /* 설명. 모든단위 테스트가 완전히 끝난 후 한 번만 동작 */
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
}
