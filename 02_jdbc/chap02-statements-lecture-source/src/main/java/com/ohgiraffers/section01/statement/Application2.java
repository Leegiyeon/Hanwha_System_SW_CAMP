package com.ohgiraffers.section01.statement;

import java.sql.*;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명. 사번을 입력받아 한명의 사원을 조회 하는 기능 */
public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명. 사용자로부터 조회하고자하는 사원의 사번을 입력받음 */
            Scanner sc = new Scanner(System.in);

            System.out.print("조회하고자 하는 사원의 사번을 입력해주세요: ");
            int empId = sc.nextInt();
            String entYn = "N";

            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND ENT_YN = '" + entYn + "'";
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println("사번: " + rset.getString("EMP_ID"));
                System.out.println("이름: " + rset.getString("EMP_NAME"));
//                System.out.println("급여: " + rset.getInt("SALARY"));       // SELECT 한 내용만 조회 가능
            } else
                System.out.println("조회결과가 없습니다.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
