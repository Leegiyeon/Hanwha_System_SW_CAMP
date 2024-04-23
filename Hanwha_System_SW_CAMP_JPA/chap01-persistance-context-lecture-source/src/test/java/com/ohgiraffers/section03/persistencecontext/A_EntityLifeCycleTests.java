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
    @Test
    public void 준영속성_detach_테스트() {

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 11);

        /* 설명.
        *   영속성 컨텍스트가 관리하던 엔터티 객체를 관리하지않는 상태가 되게 한 것을 준영속 상태라고 한다.
        *   detach가 준영속 상태를 만들기 위한 메소드 이다. */
        entityManager.detach(foundMenu2);

        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        assertEquals(5000, entityManager.find(Menu.class, 11).getMenuPrice());
        assertEquals(5000, entityManager.find(Menu.class, 12).getMenuPrice());
    }


    @Test
    public void 준영속성_clear_cloise_테스트() {
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        /* 설명. 영속성 컨텍스트로 관리되던 엔터티 객체들을 모두 비영속으로 전환 */
//        entityManager.clear();

        /* 설명. 영속성 컨텍스트 및 엔터티 매니저까지 종료 */
        entityManager.close();
        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        /* 설명. DB에서 새로 조회해 온 객체를 영속상태로 두기 때문에 다른 결과가 도출됨 */
        assertEquals(5000, entityManager.find(Menu.class, 11).getMenuPrice());
        assertEquals(5000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 병합_merge_수정_테스트(){
        Menu menuToDetach = entityManager.find(Menu.class, 3);
        entityManager.detach(menuToDetach);

        menuToDetach.setMenuName("갈치해장국");
        Menu refoundMenu = entityManager.find(Menu.class, 3);       // Memo. refoundMenu에는 기존 값

        System.out.println(menuToDetach.hashCode());
        System.out.println(refoundMenu.hashCode());

        entityManager.merge(menuToDetach);

        Menu mergedMenu =entityManager.find(Menu.class, 3);
        assertEquals("갈치해장국", mergedMenu.getMenuName());
    }

    @Test
    public void 병합_merge_삽입_테스트(){
        Menu menuToDetach = entityManager.find(Menu.class, 3);
        entityManager.detach(menuToDetach);

        menuToDetach.setMenuCode(999);
        menuToDetach.setMenuName("갈치 회");

        entityManager.merge(menuToDetach);

        Menu newMenu = entityManager.find(Menu.class, 3);
        Menu mergedMenu = entityManager.find(Menu.class, 999);
        assertNotEquals(mergedMenu.getMenuCode(), newMenu.getMenuCode());

    }

}

