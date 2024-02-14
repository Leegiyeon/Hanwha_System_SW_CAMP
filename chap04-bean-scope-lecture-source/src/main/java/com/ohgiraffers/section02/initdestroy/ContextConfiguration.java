package com.ohgiraffers.section02.initdestroy;

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

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    /* 설명. 빈의 생성과 소멸 시점에 실행할 메소드 이름 설정 */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner () {
        return new Owner();
    }
}
