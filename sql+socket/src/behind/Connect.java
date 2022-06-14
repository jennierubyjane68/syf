package behind;


import java.sql.*;

import javax.swing.JOptionPane;
 
public class Connect {
	
	  
    // 连接
    private Connection con = null;
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://127.0.0.1:3306/手术室?useSSL=true&characterEncoding=utf-8&user=root&password=123456";
    public String username = "root";
    public String password = "123456";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    // 获取连接
    public Connection getConnection() {
    	   try {  
    		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序     
    		      //Class.forName("org.gjt.mm.mysql.Driver");  
    		     System.out.println("Success loading Mysql Driver!");  
    		    }  
    		    catch (Exception e) {  
    		      System.out.print("Error loading Mysql Driver!");  
    		      e.printStackTrace();  
    		    }  
    		    try {  
    		      con = DriverManager.getConnection(  
    		          "jdbc:mysql://localhost:3306/手术室","root","123456");  
    		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码  
    		  
    		      System.out.println("Success connect Mysql server!");

    		      } catch (Exception e) {  
    			     System.out.print("get data error!");  
    			      e.printStackTrace();  
    			    }  
        return con;
    }
 
    // 关闭连接
    public void close() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
            System.out.println("数据库连接关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    // 测试
//  public static void main(String[] args) {
  //      Connect dbUtil = new Connect();
    //    dbUtil.getConnection();
         
//    }
 
}