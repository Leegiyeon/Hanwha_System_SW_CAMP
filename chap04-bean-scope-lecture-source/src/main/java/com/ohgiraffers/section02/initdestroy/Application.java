package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
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

        /* 설명. main 메소드 종료 전, 의도적으로 container를 소멸하기 */
        ((AnnotationConfigApplicationContext)context).close();

    }
}
