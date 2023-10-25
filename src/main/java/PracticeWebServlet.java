import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PracticeWebServlet
 */
@WebServlet("/showname")
public class PracticeWebServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		String no = req.getParameter("no");
		System.out.println(no);
		
		final String URL = "jdbc:mysql://localhost/sampledb";
		final String USER = "root";
		final String PASS = "password";
		String sql = "SELECT name FROM student WHERE no=" + no;
		System.out.println(sql);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			String name = rs.getString("name");
			System.out.println(name);
			req.setAttribute("name", name);
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
		RequestDispatcher rd = req.getRequestDispatcher("/practiceWeb.jsp");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    doPost(req, res);
	}
}