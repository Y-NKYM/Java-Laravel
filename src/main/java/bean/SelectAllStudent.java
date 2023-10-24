package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllStudent{
    public static void main(String[] args){
        final String URL = "jdbc:mysql://localhost/sampledb";
        final String USER = "ユーザー名";
		final String PASS = "パスワード";
		String sql = "SELECT * FROM student";

        Connection con = null;
		Statement stmt = null;
        ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

            System.out.println("+-------+-------+-------+");
            System.out.println("| id    | name  | score |");
            System.out.println("+-------+-------+-------+");

            while(rs.next()){
                System.out.print("| " + rs.getInt("no") + "\t");
                System.out.print("| " + rs.getString("name") + "\t");
                System.out.println("| " + rs.getInt("score") + "\t|");
            }
            System.out.println("+-------+-------+-------+");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
                if(rs != null) rs.close(); 
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
    }
}