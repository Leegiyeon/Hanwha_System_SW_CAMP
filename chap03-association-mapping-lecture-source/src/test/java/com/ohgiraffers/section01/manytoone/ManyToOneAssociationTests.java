package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManyToOneAssociationTests {
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

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 설명.
    *   Association Mapping은 Entity 클래스 간의 관계를 매핑하는 것이다.(JOIN))
    *   이를통해 객체를 이용하여 데이터베이스의 테이블간의 관계를 통해 힌번에 객체로 조회할 수 있다.
    *
    *  설명.
    *   1. 다중성에 의한 분류
    *     : 연관 관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류한다.
    *     - N:1
    *     - 1:N
    *     - 1:1
    *     - N:N
    *   2. 방향에 따른 분류
    *     : 테이블의 연관관계는 외래키를 이용하여 양방향 연관 관계의 특징을 가진다.
    *       반면, 객체는 참조에 의한 연관관계로 단방향이다.
    *       객체간의 연관관계를 양방향으로 만들고 싶은 경우 반대쪽에서도 필드를 추가하여 참조를 보관하면 된다.
    *     - 단방향
    *     - 양방향
    * */


    @Test
    void 다대일＿연관관계＿객체＿그래프＿탐색을＿이용한＿조회＿테스트() {
        int menuCode = 15;
        MenuAndCategory foundMenu = entityManager.find(MenuAndCategory.class, menuCode);
        Category menuCategory = foundMenu.getCategory();

        assertNotNull(menuCategory);
        System.out.println("foundMenu = " + foundMenu);
        System.out.println("menuCategory = " + menuCategory);

    }
}
