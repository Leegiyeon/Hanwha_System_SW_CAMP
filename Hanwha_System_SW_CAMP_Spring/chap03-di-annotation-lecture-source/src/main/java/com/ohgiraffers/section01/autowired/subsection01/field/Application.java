package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* 설명. AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하여 ComponentScan 개념을 바로 적용 */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookService", BookService.class);

        /* 설명. 전체 도서 조회 */
        bookService.findAllBook().forEach(System.out::println); // ArrayList


        /* 설명. 도서번호로 조회 */
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));

    }
}
