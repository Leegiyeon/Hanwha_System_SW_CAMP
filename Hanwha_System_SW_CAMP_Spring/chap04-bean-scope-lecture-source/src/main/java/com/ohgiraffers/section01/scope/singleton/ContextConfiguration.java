package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("바나나맛우유", 1800, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("제주삼다수", 800, 500);
    }

//    @Bean
//    public ShoppingCart cart () {
//        return new ShoppingCart();
//    }


    /* 설명. 스프링 컨테이너(IOC)는 bean 객체를 기본적으로 싱글톤으로 관리한다.
    *       빈 스코프를 수정하게되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다. */
//        @Bean
//    @Scope("singleton")
//    public ShoppingCart cart() {
//        return new ShoppingCart();
//    }
    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }


}
