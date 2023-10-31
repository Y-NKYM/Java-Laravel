

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import bean.LoginDAO;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registeruser")
public class RegisterUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = req.getRequestDispatcher("/registeruser.jsp");
	    rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		LoginDAO ldao = new LoginDAO();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String email_msg = null;
		String pass_msg = null;
		
		if(email == null || password == null) {
			if(email == null) {
				email_msg = "Email can not be blank";
			}
			if(password == null) {
				pass_msg = "Password can not be blank";
			}
			req.setAttribute("email_msg", email_msg);
			req.setAttribute("pass_msg", pass_msg);
			RequestDispatcher rd = req.getRequestDispatcher("/registeruser.jsp");
		    rd.forward(req, res);
		} else {
			ldao.insert(email, password);
			LoginBean lb = ldao.login(email);
			req.setAttribute("lb", lb);
			RequestDispatcher rd = req.getRequestDispatcher("/mypage.jsp");
		    rd.forward(req, res);	
		}
	}
}