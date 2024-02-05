package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        /* 설명. DML 작업 시, 반환결과 값은 int가 된다.(ResultSet 사용하지 않음)
        *   그리고 기존 조회의 경우, excuteQuery()를 사용했지만, DML 작업 시, excuteUpdate()를 사용한다. */
        int result = 0;

        String query = "INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)"
                + "VALUES (?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "봉골레 청국장");
            pstmt.setInt(2, 5000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            /* 설명. 자동 커밋상태에서 excuteUpdate하면 자동을 커밋된다.(Template에서 수동으로 설정) */
            result = pstmt.executeUpdate();

            if (result > 0){
                System.out.println("insert 결과: " + result + ", 수동 커밋하기!");
                con.commit();
            } else
                con.rollback();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

    }
}
