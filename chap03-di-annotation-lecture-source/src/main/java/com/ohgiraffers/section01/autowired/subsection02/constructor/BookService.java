package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookServiceConstructor")
public class BookService {

    /* Memo. 필드 주입에서는 final을 붙일 수 없다. */
    private final BookDAO bookDAO;

    /* 설명.
     *  BookDAO Type의 bean 객체를 생성자를 통해 주입 받는다.
     *  (@Autowired를 생성자에 작성하고 주입받을 타입의 bean을 매개변수로 작성한다.) (기본생성자 X)
     *
     * 설명.
     *  생성자 주입의 장점
     *     1. 필드에 final 키워드 사용
     *     2. 순환 참조 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러 발생
     *     3. 중간에 값이 오염되지 않음을 확신할 수 있다.(불변성)
     *     4. 테스트 코드 작성시 테스트 코드에 @Autowired 또는 주입받는 대상의 setter등을 추가하지 않고 순수 자바코드로 테스트 가능
    * */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.searchBookBySequence(sequence);
    }
}
