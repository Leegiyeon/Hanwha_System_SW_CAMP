package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;


public class A_EntityManagerLifeCycleTests {


    /* 필기.
     *  엔터티 매니저 팩토리(Entity Manager Factory)
     *   엔터티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스
     *   thread-safe하기 때문에 여러 스레드가 동시에 접근해도 안전하므로 서로 다른 스레드 간 공유해서 재사용한다.
     *   thread-safe한 기능을 요청 스코프마다 생성하기에는 비용부담이 크므로 Application 스코프와 동일하게
     *   싱글톤으로 생성하여 관리하는 것이 효율적이다
     *  엔터티 매니저(Entity Manager)
     *   엔터티 매니저는 엔터티를 저장하는 메모리상의 데이터 베이스를 관리하는 인스턴스이다.
     *   엔터티를 저장, 수정, 삭제, 조회하는 등의 엔터티와 관련된 모든 일을 한다.
     *   동시성 문제가 발생할 수도 있다.
     *  영속성 컨텍스트
     *   엔터티 매니저를 통해 엔터티를 저장하거나 조회하면 엔터티 매니저는 영속성 컨텍스트에 엔터티를 보관한다.
     *   영송성 컨텍스트는 엔터티를 key-value 방식으로 저장하는 저장소이다.
     *   엔터티매니저를 생성할 때 하나씩 만들어진다.
     *   그리고 엔터티 매니저를 통해서 영속성 컨텍스트에 엔터티를 보관하고 관리한다.
    * */
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void 엔터티_매니저_팩토리와_엔터티_매니저_생명주기_확인1(){
        System.out.println("entityManagerFactory.hashCode() = " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode() = " + entityManager.hashCode());
    }
    @Test
    public void 엔터티_매니저_팩토리와_엔터티_매니저_생명주기_확인2(){
        System.out.println("entityManagerFactory.hashCode() = " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode() = " + entityManager.hashCode());
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

}
