

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	    rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {		
		req.setCharacterEncoding("utf-8");
		
		LoginDAO ldao = new LoginDAO();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		LoginBean lb = ldao.login(email);
		String message = null;
		
		if(lb.getEmail() != null) {
			if(lb.getPassword().equals(password)) {
				System.out.println("match found");
				RequestDispatcher rd = req.getRequestDispatcher("/mypage.jsp");
			    rd.forward(req, res);
			} else {
				System.out.println("not match password");
				message = "not match password";
			}
		} else {
			System.out.println("not match email");
			message = "not match email";
		}
		System.out.println("email=" + email+ ", password="+password);
		req.setAttribute("lb", lb);
		req.setAttribute("message", message);
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	    rd.forward(req, res);
	}

}
