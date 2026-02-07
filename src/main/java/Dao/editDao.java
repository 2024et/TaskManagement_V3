package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.editBeans;

public class editDao {
	//タスク削除
	public boolean Delete(String TaskId, String User) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            String sql = "DELETE FROM sama WHERE id = ? AND userId = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,TaskId);
            stmt.setString(2, User); 

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;

        }
    }
	//時間割から削除
	public boolean DeleteAuto(String TaskId, String User) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            String sql = "DELETE FROM auto WHERE id = ? AND userId = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,TaskId);
            stmt.setString(2, User); 

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;

        }
    }
	//データ更新
	public boolean UpdateData(editBeans bean) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            String sql = "UPDATE sama SET deadline = ?, class = ?, category = ?, contents = ?, other = ?, process = ?, attend = ? WHERE id = ? AND userId = ? ";
            stmt = con.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(bean.getDeadline().getTime()));
            stmt.setString(2, bean.getClasss()); 
            stmt.setString(3, bean.getCategory());
            stmt.setString(4, bean.getContents());
            stmt.setString(5, bean.getOther());
            stmt.setString(6, bean.getProcess());
            stmt.setString(7, bean.getAttend());
            stmt.setString(8, bean.getTaskId());
            stmt.setString(9, bean.getUserId());
            

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;

        }
    }

}
