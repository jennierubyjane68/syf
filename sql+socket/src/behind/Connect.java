package behind;


import java.sql.*;

import javax.swing.JOptionPane;
 
public class Connect {
	
	  
    // ����
    private Connection con = null;
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://127.0.0.1:3306/������?useSSL=true&characterEncoding=utf-8&user=root&password=123456";
    public String username = "root";
    public String password = "123456";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    // ��ȡ����
    public Connection getConnection() {
    	   try {  
    		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������     
    		      //Class.forName("org.gjt.mm.mysql.Driver");  
    		     System.out.println("Success loading Mysql Driver!");  
    		    }  
    		    catch (Exception e) {  
    		      System.out.print("Error loading Mysql Driver!");  
    		      e.printStackTrace();  
    		    }  
    		    try {  
    		      con = DriverManager.getConnection(  
    		          "jdbc:mysql://localhost:3306/������","root","123456");  
    		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������  
    		  
    		      System.out.println("Success connect Mysql server!");

    		      } catch (Exception e) {  
    			     System.out.print("get data error!");  
    			      e.printStackTrace();  
    			    }  
        return con;
    }
 
    // �ر�����
    public void close() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
            System.out.println("���ݿ����ӹر�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    // ����
//  public static void main(String[] args) {
  //      Connect dbUtil = new Connect();
    //    dbUtil.getConnection();
         
//    }
 
}