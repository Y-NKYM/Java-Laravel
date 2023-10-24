package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudent {
	
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost/sampledb";
		final String USER = "ユーザー名";
		final String PASS = "パスワード";
		String sql = "INSERT INTO student VALUES(6, '小林', 95)";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "件更新しました");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
