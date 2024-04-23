package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class BidirectionTests {
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


    /* 설명. 양방향 연관 관계는 지양되는 방식이며 순환참조 시, 조심하여야 한다. */
    @Test
    public void 양방향_연관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        /* 설명. 연관관계의 주인인 엔터티는 한번에 join문으로 관계를 맺은 엔터티를 조회할 수 있다. */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        /* 설명. 양방향은 부모에 해당하는 엔터티와 가짜연관 관계이고, 필요 시, 연관관계 엔터티를 조회하는 쿼리를 다시 실행할 수 있다.*/
        Category foundCategory = entityManager.find(Category.class, categoryCode);

        /* 설명. getMenuList()시점에 관계를 맺은 Menu 엔터티가 필여하여 Select문이 적용된다. */
        foundCategory.getMenuList().forEach(System.out::println);

    }
}
