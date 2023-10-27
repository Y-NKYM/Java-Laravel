import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeWebServlet
 */
@WebServlet("/getinfo")
public class GetInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    req.setCharacterEncoding("utf-8");
	    
	  
	    
	    req.setAttribute("message", "HelloWorld!");
	    String name = req.getParameter("name");
	    if(name != null) {
	    	req.setAttribute("name", name);
	    }
	    RequestDispatcher rd = req.getRequestDispatcher("getInfo.jsp");
	    rd.forward(req, res);
	}
}