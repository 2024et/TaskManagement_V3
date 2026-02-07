package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.indexBeans;


	public class indexDao {	
		//データ取得
	    public List<indexBeans>GetData(String userId) {
	        List<indexBeans> list = new ArrayList<>();
	        Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	
	        String sql = "SELECT * FROM sama WHERE userId = ? ORDER BY deadline";
	
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");
	
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, userId); 
	            rs = stmt.executeQuery();
	
	            while (rs.next()) {
	                indexBeans bean = new indexBeans();
	                bean.setTaskId(rs.getString("id"));
	                bean.setDeadline(rs.getDate("deadline"));
	                bean.setClasss(rs.getString("class"));
	                bean.setCategory(rs.getString("category"));
	                bean.setContents(rs.getString("contents"));
	                bean.setOther(rs.getString("other"));
	                bean.setProcess(rs.getString("process"));
	                bean.setAttend(rs.getString("attend"));
	                bean.setUserId(rs.getString("userId"));
	                list.add(bean);
	            }

	
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        } 
	        return list;
	   }
}
