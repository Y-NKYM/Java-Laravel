import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO2;
import bean.StudentDTO;

/**
 * Servlet implementation class PracticeWebStudentServlet
 */
@WebServlet("/showStudents")
public class PracticeWebStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
			
		StudentDAO2 sdao = new StudentDAO2();
		StudentDTO sdto = sdao.select();
		
		req.setAttribute("sdto", sdto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/showstudents.jsp");
		rd.forward(req, res);
		}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    doPost(req, res);
	}
}
