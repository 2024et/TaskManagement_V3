package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.loginBeans;


public class loginDao {
	//ログイン
	public loginBeans LoginD(String username) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");
	        
	        String sql = "SELECT * FROM Account WHERE name = (?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);  
	        
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	loginBeans result_data = new loginBeans(rs.getString("name"),rs.getString("password"));
	            return result_data;
	        } else {
	        	loginBeans result_data = new loginBeans("","");
	            return result_data;
	        }
	    }catch (ClassNotFoundException e) {
	        System.out.println("JDBCドライバのロードでエラーが発生しました");
	        System.out.println(e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("データベースへのアクセスでエラーが発生しました。");
	        System.out.println(e.getMessage());
	    } 
	    loginBeans result_data = new loginBeans("","");
        return result_data;
	}
}
