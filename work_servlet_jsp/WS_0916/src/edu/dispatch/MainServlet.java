package edu.dispatch;

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
@WebServlet("/mainservlet.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.한글처리
		request.setCharacterEncoding("utf-8");
		// 2.파라미터처리
		String id = request.getParameter("text");
		String passwd = request.getParameter("password");
		// 3.업무처리
		// 로그인 가능 여부 처리
		boolean islogin = false;
		if (id.equals("ssafy")&&passwd.equals("1111")) {
			islogin = true;
		} else {
			islogin = false;
		}
		// 4.출력처리
		if (islogin) {
			// ssafy ssafy 입력시에 pass
			// 아니면 redirect()
			String msg = id+"님 로그인 성공되었습니다.!!!";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(request, response);
			// 포워드 하면 다른 서블릿으로 완전히 넘어가서 이후의 코드는 실행되지 않다
			// 다음 코드 실행시키고 싶으면 include() 하면 돼
		} else {
			String msg1="도서 정보 관리 ERROR";
			request.setAttribute("msg1", msg1);
			String msg2="아이디 또는 패스워드가 다릅니다.";
			request.setAttribute("msg2", msg2);
			
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}

}
