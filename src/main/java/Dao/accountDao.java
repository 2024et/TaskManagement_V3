package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Beans.accountBeans;

public class accountDao {
	
	//ユーザー名重複確認
	public boolean Duplication(String UserID) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://servername/dbname", "user", "password");
	        
	        String sql = "SELECT * FROM Account WHERE name = (?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, UserID);  
	        
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            return true;
	        } else {
	            return false;
	        }
	    }catch (ClassNotFoundException e) {
	        System.out.println("JDBCドライバのロードでエラーが発生しました");
	        System.out.println(e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("データベースへのアクセスでエラーが発生しました。");
	        System.out.println(e.getMessage());
	    }
		return false;
	}
	
	//新規登録
	public boolean RegistData(accountBeans inputData) {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");
	        
	        String sql = "INSERT INTO Account (id,name, password) VALUES (?,?, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, RandomID());  
	        pstmt.setString(2, inputData.getUsername());  
	        pstmt.setString(3, inputData.getPassword());  

	        int count = pstmt.executeUpdate();
	        
	        if (count > 0) {
	            return true;
	        }
	    	
	    }catch (ClassNotFoundException e) {
	        System.out.println("JDBCドライバのロードでエラーが発生しました");
	        System.out.println(e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("データベースへのアクセスでエラーが発生しました。");
	        System.out.println(e.getMessage());
	    } 
		return false;
	}
	
	//ID生成
	public String RandomID() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) digits.add(i);

        Collections.shuffle(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(digits.get(i));
        }        
        return sb.toString();
    }

}
