package edu.ssafy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String catalogue = req.getParameter("catalogue");
		String nation = req.getParameter("nation");
		String publisheDate = req.getParameter("publisheDate");
		String publisher = req.getParameter("publisher");
		String author = req.getParameter("author");
		String price = req.getParameter("price");
		String currency = req.getParameter("currency");
		String description = req.getParameter("description");
		
		req.setAttribute("isbn", isbn);
		req.setAttribute("title", title);
		req.setAttribute("catalogue", catalogue);
		req.setAttribute("nation", nation);
		req.setAttribute("publisheDate", publisheDate);
		req.setAttribute("publisher", publisher);
		req.setAttribute("author", author);
		req.setAttribute("price", price);
		req.setAttribute("currency", currency);
		req.setAttribute("description", description);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
		
		rd.forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		boolean islogin = false;
		if(id.equals("ssafy") && passwd.equals("1111")) {
			islogin = true;
		}else {
			islogin = false;
		}
		
		if(islogin) {
			String msg = id;
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			
			rd.forward(request, response);
		}else {
			String msg1 = "도서 정보 관리 ERROR";
			request.setAttribute("msg1", msg1);
			String msg2 = "아이디 또는 패스워드가 다릅니다.";
			request.setAttribute("msg2", msg2);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}
}
