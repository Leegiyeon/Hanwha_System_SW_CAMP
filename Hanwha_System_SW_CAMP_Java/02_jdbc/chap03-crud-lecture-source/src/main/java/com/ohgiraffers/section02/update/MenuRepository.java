package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int modifyMenu(Connection con, Menu modifyMenu) {

        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("updateMenu");

            System.out.println("query = " + query);


            /* Memo. 쿼리문의 입력값 순서와 동일하게 작성 */
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
