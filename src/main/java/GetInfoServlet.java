import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * WebServlet指定ルートを記述でサーブレットの読み込み。
 * JSPファイルの拡張子記述でサーブレット読み込むことなくJSPを表示。
 */
@WebServlet("/hello/*")
public class GetInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    req.setCharacterEncoding("utf-8");
	    
	    req.setAttribute("message", "HelloWorld!");
	    String name = req.getParameter("name");
	    if(name != null) {
	    	req.setAttribute("name", name);
	    }
	    String servInfo = req.getServletPath();
	    String pathInfo = req.getPathInfo();
	    System.out.println(servInfo.substring(1));
	    System.out.println(pathInfo);
	    RequestDispatcher rd = req.getRequestDispatcher("../getInfo.jsp");
	    rd.forward(req, res);
	}
}