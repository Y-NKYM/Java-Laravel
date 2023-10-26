import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO;


/**
 * Servlet implementation class PracticeWebServlet
 */
@WebServlet("/showname")
public class PracticeWebServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
		
		StudentDAO sdao = new StudentDAO();
		sdao.connect();
		
		req.setCharacterEncoding("utf-8");
		String no = req.getParameter("no");
		
		String name = sdao.select(Integer.parseInt(no));
		sdao.disconnect();
		
		req.setAttribute("name", name);
		
		RequestDispatcher rd = req.getRequestDispatcher("/practiceWeb.jsp");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    doPost(req, res);
	}
}