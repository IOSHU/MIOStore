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
//    private final String user = "root";
//    private final String passwd = "2281998";
//    private final String url = "jdbc:mysql://localhost:3306/";
//    private final String db = "miostore1";
//   ' private Connection conn;
       private static Connection conn = null;
    public static String port = "3306";
    public static String hostName = "localhost";
    public static String sqlInstanceName = "BTANH2020";
    public static String database = "miostore1";
    public static String userName = "root";
    public static String password = "2281998";

    private static DbConnection dbConnection;
    
    protected DbConnection() {}
    
    public static DbConnection getInstance() {
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
    
//    public Connection getConnection() {
//        if (this.conn == null) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                this.conn = DriverManager.getConnection(url+db, user, passwd);
//            } catch (SQLException ex) {
//                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
//                
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return this.conn;
//    }
//    
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

    // Kết nối vào SQLServer.
    // (Sử dụng thư viện điều khiển SQLJDBC)
    public static Connection getConnection()            {
        if (conn == null) {
            try {
                return getConnection(hostName, port,
                        database,userName,password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return conn;
        }
        return null;
    }


    public static Connection getConnection(String hostName,String port,
             String database, String userName,
            String password) throws ClassNotFoundException, SQLException {
        if(conn == null){
            // Khai báo class Driver cho DB SQLServer
            // Việc này cần thiết với Java 5
            // Java6 tự động tìm kiếm Driver thích hợp.
            // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Cấu trúc URL Connection dành cho SQLServer
            // Ví dụ:
            // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
            String connectionURL= "jdbc:mysql://"+hostName+":"+port+"/"+database+"?autoReconnect=true&useSSL=false";
            conn = (Connection)DriverManager.getConnection(connectionURL, userName,
                    password);
        }
        return conn;
    }
    

 
}
