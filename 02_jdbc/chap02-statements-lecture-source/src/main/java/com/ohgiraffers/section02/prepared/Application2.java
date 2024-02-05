package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;


/* 설명.
 *  PreparedStatement는 PlaceHolder(?)를 사용한 쿼리를 파싱하고 캐싱하여 다시 재해석하는 과정을 생략함으로써
 *  불완전하게 작성된 쿼리의 경우 Statement보다 빠르다.
* */
public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고자 하시는 사번을 입력해주세요: ");
        String empId = sc.nextLine();
        String entYn = "N";

        /* 설명. PreparedStatement는 Statement와 달리 placeholder(?)를 활용한 하나의 문자열 형태로 쿼리작상이 가능하다. */
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery();

            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            } else
                System.out.println("조회결과가 없습니다.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
