/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieule
 */
public class DbConnection {
    private final String user = "archer";
    private final String passwd = "archer";
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String db = "miostore";
    private Connection conn;
    private static DbConnection dbConnection;
    
    protected DbConnection() {}
    
    public static DbConnection getInstance() {
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
    
    public Connection getConnection() {
        if (this.conn == null) {
            try {
//                Class.forName("com.mysql.jdbc.Driver");
                this.conn = DriverManager.getConnection(url+db, user, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.conn;
    }
    
    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.conn = null;
    }
   
}
