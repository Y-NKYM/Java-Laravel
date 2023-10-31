package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
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
	
	public LoginDTO select(){
		Statement stmt = null;
		ResultSet rs = null;
		
		LoginDTO ldto = new LoginDTO();
		String sql = "SELECT * FROM user";
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				LoginBean lb = new LoginBean();
				lb.setId(rs.getInt("id"));
				lb.setEmail(rs.getString("email"));
				lb.setPassword(rs.getString("password"));
				ldto.add(lb);
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
		return ldto;
	}
	
	public LoginBean login(String email) {
		Statement stmt = null;
		ResultSet rs = null;
		LoginBean lb = new LoginBean();
		
		String sql = "SELECT * FROM user WHERE email='"+email+"'";
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			lb.setId(rs.getInt("id"));
			lb.setEmail(rs.getString("email"));
			lb.setPassword(rs.getString("password"));
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
		return lb;
	}
	
	public int insert(String email, String password) {
		String sql = "INSERT INTO user(email, password) VALUES("+"'"+email+"', '"+password+"')";
		return executeSql(sql);
	}
	public int update(int id, String email, String password) {
		String sql = "UPDATE user SET id="+id+", email='"+email+"',password="+password+" WHERE id="+id;
		return executeSql(sql);
	}
	public int delete(int id) {
		String sql = "DELETE FROM user WHERE id="+id;
		return executeSql(sql);
	}
	public int executeSql(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connect();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
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
