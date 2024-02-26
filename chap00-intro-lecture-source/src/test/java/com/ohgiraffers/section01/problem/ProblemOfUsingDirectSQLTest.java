package com.ohgiraffers.section01.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemOfUsingDirectSQLTest {

    private Connection con;

    @BeforeEach
    void setConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "swcamp";
        String password = "swcamp";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
    }


    @AfterEach
    void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    /* 설명. JDBC API를 이용해 직접 SQL을 다룰 때, 발생할 수 있는 문제점
    *   1. 데이터 변환, SQL 작성, JDBC API 코드 등의 중복 작성(개발시간 증가, 유지보수성 저하)
    *   2. SQL에 의존
    *   3. 패러다임 불일치(상속,연관관계, 객체 그래프 탐색, 방향성)
    *   4. 동일성 보장 문제
    * */

    /* Memo. 1. 데이터 변환, SQL 작성, JDBC API 코드 등의 중복 작성(개발시간 증가, 유지보수성 저하) */
    @DisplayName("직접 SQL을 작성하여 메뉴를 조회할 때 발생하는 문제 확인")
    @Test
    void testDirectSelectSql() throws SQLException {

        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, " + "ORDERABLE_STATUS FROM TBL_MENU";

        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuPrice(rset.getInt("MENU_PRICE"));
            menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
            menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

            menuList.add(menu);

        }

        Assertions.assertTrue(!menuList.isEmpty());
        menuList.forEach(System.out::println);

        rset.close();
        stmt.close();

    }

    @DisplayName("직접 SQL을 작성하여 신규메뉴를 추가할 때 발생하는 문제 확인")
    @Test
    void testDirectInsertSQL() throws SQLException {
        Menu menu = new Menu();
        menu.setMenuName("민트초코짜장면");
        menu.setMenuPrice(15000);
        menu.setCategoryCode(1);
        menu.setOrderableStatus("Y");

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setString(1, menu.getMenuName());
        pstmt.setInt(2,menu.getMenuPrice());
        pstmt.setInt(3, menu.getCategoryCode());
        pstmt.setString(4, menu.getOrderableStatus());

        int result = pstmt.executeUpdate();

        Assertions.assertEquals(1, result);
        pstmt.close();


    }

    /* Memo. 2. SQL에 의존 */
    @DisplayName("조회항목 변경에 따른 의존성 확인")
    @Test
    void testChangeSelectColumns() throws SQLException {
        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE FROM TBL_MENU";

        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuPrice(rset.getInt("MENU_PRICE"));

            menuList.add(menu);
        }

        Assertions.assertTrue(!menuList.isEmpty());
        menuList.forEach(System.out::println);

        rset.close();
        stmt.close();
    }


}
