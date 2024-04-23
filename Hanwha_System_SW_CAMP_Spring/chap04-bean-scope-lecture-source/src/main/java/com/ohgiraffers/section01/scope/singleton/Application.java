package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 설명.
    *   bean scope
    *      스프링 빈이 생성될 때, 해당 인스턴스의 범위를 의미한다. 스프링에서는 다양한 bean scope를 제공한다.
    *      1. singleton: 하나의 인스턴스만을 생성, 모든 빈이 해당 인스턴스를 공유
    *      2. prototype: 매번 새로운 인스턴스 생성
    *      3. request: Http요청을 처리할때마다 새로운 인스턴스 생성, 요청처리가 끝남과 동시에 폐기(웹 애플리케이션 컨텍스트만 해당)
    *      4. session: Http세션 당 하나의 인스턴스 생성, 세션 종료 시 폐기(웹 애플리케이션 컨텍스트만 해당)
    *      5. globalSession: 전역 세션 당 하나의 인스턴스 생성, 전역 세션이 종료 시 폐기(포턴 애플리케이션 컨텍스트만 해당)
    * */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName: beanNames) {
            System.out.println("beanName = " + beanName);
        }


        /* 설명. 붕어빵, 바나나 우유, 제주삼다수 빈 객체를 반환 받아 변수에 넣기 */
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 설명. 첫 손님이 물건을 카트에 담는다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        /* 설명. 첫 손님 카트에 담긴 물건 확인 */
        System.out.println("cart1의 물건: " + cart1.getItems());


        /* 설명. 두 번째 손님이 물건을 카트에 담는다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        /* 설명. 두 번째 손님 카트에 담긴 물건 확인 */
        System.out.println("cart2의 물건: " + cart2.getItems());

        /* Memo. 객체의 주소값이 같음을 확인 */
        System.out.println(System.identityHashCode(cart1)==System.identityHashCode(cart2));

    }
}
