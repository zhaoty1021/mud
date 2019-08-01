package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url= "jdbc:mysql://localhost:3306/userlist?characterEncoding=utf-8";
	private static final String user = "root";
	private static final String password = "1025338403";
    
    public Connection conn;
    public Connection getconn() {
    	conn=null;
        try {
            Class.forName(driver);// 加载驱动程序
            conn = DriverManager.getConnection(url, user, password);// 连续数据库
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
