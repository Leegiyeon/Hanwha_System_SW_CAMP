package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    /* Memo. 1. @Service 에 의해서 BookService 타입의 bookService bean이 관리된다. */
    /* Memo. 2. BookDAOImpl에 있는 Repository 에 의해서 bookDAOImpl Bean이 관리된다.(BookDAO타입이기도 함) */
    /* Memo. 3. @Autowired에 의해서 BookDAO 타입의 bean이 BookService의 필드인 bookDAO 필드에 주입된다.(대입) */
    @Autowired
    private BookDAO bookDAO;

    public BookService() {
    }

    /* 설명. 도서목록 전체 조회 */
    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 조회 */
    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.searchBookBySequence(sequence);
    }
}
