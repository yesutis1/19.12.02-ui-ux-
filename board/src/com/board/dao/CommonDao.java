package com.board.dao;

import java.sql.*;

public class CommonDao {
    private final String driverName="org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mysql://10.10.10.134:3306/my_site";
    private final String db_id = "yesutis1";
    private final String db_pw = "asdf1234";
    
    private Connection con = null;
    private Statement stmt = null;
    
    public Statement openConnection() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, db_id, db_pw);
            stmt = con.createStatement();
        } catch(Exception e) {
            System.out.println("Oracle 데이터베이스 db 접속에 문제가 있습니다. <hr>");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return stmt;
    }
    
    public void closeConnection() {
        try {
            if(!con.isClosed()) {
                con.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
