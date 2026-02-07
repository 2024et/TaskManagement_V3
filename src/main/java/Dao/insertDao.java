package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.insertAuto;
import Beans.insertBeans;

public class insertDao {
	//データ新規登録
	public boolean RegistData(insertBeans bean) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            String sql = "INSERT INTO sama (id, deadline, class, category, contents, other, process, attend, userId) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,bean.getTaskId());
            stmt.setDate(2, new java.sql.Date(bean.getDeadline().getTime()));
            stmt.setString(3, bean.getClasss()); 
            stmt.setString(4, bean.getCategory());
            stmt.setString(5, bean.getContents());
            stmt.setString(6, bean.getOther());
            stmt.setString(7, bean.getProcess());
            stmt.setString(8, bean.getAttend());
            stmt.setString(9, bean.getUserId());

            int rows = stmt.executeUpdate();
            System.out.println("INSERT 成功 (" + rows + "件)");
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("INSERT 失敗");
            e.printStackTrace();
            return false;

        }
    }
	
	//時間割新規登録
	public boolean AutoRegistData(insertAuto bean) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            String sql = "INSERT INTO auto (week, class, category, contents, other, deadprocess, id, userId) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, bean.getDeadline());
            stmt.setString(2, bean.getClasss()); 
            stmt.setString(3, bean.getCategory());
            stmt.setString(4, bean.getContents());
            stmt.setString(5, bean.getOther());
            stmt.setString(6, bean.getDeadprocess());
            stmt.setString(7, bean.getTaskId());
            stmt.setString(8, bean.getUserId());

            int rows = stmt.executeUpdate();
            System.out.println("INSERT 成功 (" + rows + "件)");
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("INSERT 失敗");
            e.printStackTrace();
            return false;

        } 
    }
    //時間割データ取得
	public List<insertAuto>GetData(String userId) {
        List<insertAuto> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM auto WHERE userId = ? ORDER BY CASE week\n"
        		+ "    WHEN '日曜日' THEN 1\n"
        		+ "    WHEN '月曜日' THEN 2\n"
        		+ "    WHEN '火曜日' THEN 3\n"
        		+ "    WHEN '水曜日' THEN 4\n"
        		+ "    WHEN '木曜日' THEN 5\n"
        		+ "    WHEN '金曜日' THEN 6\n"
        		+ "    WHEN '土曜日' THEN 7\n"
        		+ "END;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://servername/dbname\", \"user\", \"password");

            stmt = con.prepareStatement(sql);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	insertAuto bean = new insertAuto();
            	bean.setDeadline(rs.getString("week"));
                bean.setClasss(rs.getString("class"));
                bean.setCategory(rs.getString("category"));
                bean.setContents(rs.getString("contents"));
                bean.setOther(rs.getString("other"));
                bean.setDeadprocess(rs.getString("deadprocess"));
                bean.setTaskId(rs.getString("id"));
                bean.setUserId(rs.getString("userId"));
                list.add(bean);
            }

            System.out.println("データ件数: " + list.size());

        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードでエラーが発生しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データベース接続エラー。");
            e.printStackTrace();
        }

        return list;
   }
}
