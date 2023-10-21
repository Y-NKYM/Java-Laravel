import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeServlet
 */
@WebServlet("/practice")
public class PracticeServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
			
		String age = req.getParameter("age");
		if(age.equals("child")) {
			age = "18歳以下";
		}else {
			age = "18歳以上";
		}
		req.setAttribute("age", age);
		
		String langs = "";
		String[] lang = req.getParameterValues("lang");
		for(int i=0; i < lang.length; i++) {
			langs = langs + lang[i] + " ";
		}
		req.setAttribute("langs", langs);
		
		RequestDispatcher rd = req.getRequestDispatcher("/practiceJSP2_2.jsp");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

}
