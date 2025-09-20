/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hd
 */
public class DButils {
    private static final String DB_NAME="UserManagement";
    private static final String USER_NAME="sa";
    private static final String PASSWORD="12345";
    private static final String DRIVER_LOADER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        Class.forName(DRIVER_LOADER);
        String url= URL+ DB_NAME;
        conn= DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
    
}
