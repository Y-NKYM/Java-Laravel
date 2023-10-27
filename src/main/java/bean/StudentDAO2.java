package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO2 {
	private final String URL = "jdbc:mysql://localhost/sampledb";
	private final String USER = "root";
	private final String PASS = "password";
	private Connection con = null;
	
	//DBに接続
	public void connect() {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public StudentDTO select(){
		Statement stmt = null;
		ResultSet rs = null;
		
		StudentDTO sdto = new StudentDTO();
		String sql = "SELECT * FROM student";
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentBean sb = new StudentBean();
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setScore(rs.getInt("score"));
				sdto.add(sb);
			}
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
		disconnect();
		return sdto;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
