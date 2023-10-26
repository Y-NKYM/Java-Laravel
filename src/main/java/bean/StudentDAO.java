package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	private final String URL = "jdbc:mysql://localhost/sampledb";
	private final String USER = "ユーザー名";
	private final String PASS = "パスワード";
	private Connection con = null;
	
	//DBに接続
	public void connect() {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String select(int stuNo){
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = "SELECT name FROM student WHERE no=" + stuNo;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getString("name");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
                if(rs != null) rs.close(); 
				if(stmt != null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
