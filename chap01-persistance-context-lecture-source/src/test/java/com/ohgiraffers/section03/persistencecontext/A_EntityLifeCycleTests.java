package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class A_EntityLifeCycleTests {
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


    /* 필기.
     *  영속성 컨텍스트는 엔터티 매니저가 엔터티 객체를 저장하는 공간으로 엔터티 객체를 보관하고 관리한다.
     *  엔터티 매니저가 생성될 때, 하나의 영속성 컨텍스트가 만들어진다.
     *
     * 필기.
     *  엔터티의 생명주기
     *  비영속, 영속, 준영속, 삭제 상태
    * */
    @Test
    public void 비영속성_테스트() {
        Menu foundMenu = entityManager.find(Menu.class, 20);
        System.out.println("foundMenu = " + foundMenu);
        /* 설명. 영속 상태의 객체에서 값을 추출해 담더라도 새로 생성되어 영속성 컨텍스트와 관련없는 객체는 비영속상태이다. */
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());

        boolean isTrue = (foundMenu == newMenu);

        assertFalse(isTrue);
    }


    @Test
    public void 영속성_연속_조회_테스트() {
        Menu foundMenu1 = entityManager.find(Menu.class, 20);
        Menu foundMenu2 = entityManager.find(Menu.class, 20);

        boolean isTrue = (foundMenu1 == foundMenu2);
        assertTrue(isTrue);
    }


    @Test
    public void 영속성_객체_추가_테스트() {
        /* 설명. menuCode필드에 값을 직접 주고자 한다.
        *   auto increment 사용 X (@GenerationValue 주석)*/
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(1);
        menuToRegist.setMenuName("우대갈비탕");
        menuToRegist.setMenuPrice(15000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");

        entityManager.persist(menuToRegist);
        Menu foundMenu = entityManager.find(Menu.class, 1);
        boolean isTrue = (menuToRegist == foundMenu);

        assertTrue(isTrue);
    }

    @Test
    public void 영속성_객체_추가_값_변경_테스트 () {
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(1);
        menuToRegist.setMenuName("우대갈비탕");
        menuToRegist.setMenuPrice(15000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");
        entityManager.persist(menuToRegist);
        menuToRegist.setMenuName("우대갈비된장");

        Menu foundMenu = entityManager.find(Menu.class, 1);
        assertEquals("우대갈비된장", foundMenu.getMenuName());
    }
}
