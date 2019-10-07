package edu.ssafy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.html"); //다이렉트 다시 실행

	}
	

	ArrayList<User> users=new ArrayList<>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//한글 위해서
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String passwd=request.getParameter("passwd");
		User user=new User(id,passwd);
		users.add(user);
		
		//System.out.println(id+","+passwd);
		String str="<h1>Connected id is "+id+" "+"<br> passwd : "+passwd+"</h1>";
		response.getWriter().write(str);
	}

}
