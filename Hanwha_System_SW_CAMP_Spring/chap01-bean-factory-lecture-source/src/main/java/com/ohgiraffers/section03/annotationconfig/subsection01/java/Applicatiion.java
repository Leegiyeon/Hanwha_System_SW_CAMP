package com.ohgiraffers.section03.annotationconfig.subsection01.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* 설명.
 *   ComponentScan과 관련하여 java클래스와 xml 방식으로 사용하는 방법을 확인
 *   java클래스와 @ComponentScan을 자주 사용하므로 익숙해지자 */
public class Applicatiion {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

    }
}
