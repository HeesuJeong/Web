

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int isbn=1;
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String pdes = request.getParameter("pdes");
		
		request.setAttribute("isbn", isbn++);
		request.setAttribute("pname", pname);
		request.setAttribute("pprice", pprice);
		request.setAttribute("pdes", pdes);
		
		RequestDispatcher rd = request.getRequestDispatcher("pstore.jsp");
		
		rd.forward(request, response);
	}

}
