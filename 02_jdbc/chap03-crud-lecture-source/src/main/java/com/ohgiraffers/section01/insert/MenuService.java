package com.ohgiraffers.section01.insert;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* 설명. Service 계층은 Connection 객체 생성 그리고 소멸(close) 및 비즈니스 로직, 트랜잭션(커밋, 롤백) 처리 */
public class MenuService {
    public void registMenu(Menu registMenu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.registMenu(con, registMenu);

        if (result > 0) {
//            con.commit();       // Memo. try/catch 대신 JDBCTemplate에 메소드를 만들어 사용
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
