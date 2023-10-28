

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO3;
import bean.StudentDTO;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/crud")
public class CrudServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
		
		String message = "生徒の情報を表示します。";
		
		req.setCharacterEncoding("utf-8");
		//btnの値を取得
		String btn = req.getParameter("btn");
		//StudentDAOオブジェクト生成
		StudentDAO3 sdao = new StudentDAO3();
		//押されたボタンによる分岐処理
		if(btn.equals("new")) {
			int no = Integer.parseInt(req.getParameter("no"));
			String name = req.getParameter("name");
			int score = Integer.parseInt(req.getParameter("score"));
			sdao.insert(no, name, score);
			message = "番号"+no+"の生徒を追加しました";
		}else if(btn.equals("edit")) {
			int no = Integer.parseInt(req.getParameter("no"));
			String name = req.getParameter("name");
			int score = Integer.parseInt(req.getParameter("score"));
			sdao.update(no, name, score);
			message = "番号"+no+"の生徒を修正しました";
		}else if(btn.equals("delete")) {
			int no = Integer.parseInt(req.getParameter("no"));
			sdao.delete(no);
			message = "番号"+no+"の生徒を削除しました";
		}
		//全件検索
		StudentDTO sdto = sdao.select();
		req.setAttribute("sdto", sdto);
		req.setAttribute("message", message);
		RequestDispatcher rd = req.getRequestDispatcher("/crud.jsp");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	    doPost(req, res);
	}
}
