package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudent {
	
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost/sampledb";
		final String USER = System.getenv("DB_USERNAME");
		final String PASS = System.getenv("DB_PASSWORD");
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
