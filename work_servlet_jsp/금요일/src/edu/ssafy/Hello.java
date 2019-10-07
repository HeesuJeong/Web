package edu.ssafy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키를 하나 구워서 줘봅시다:)
		
		Cookie cookie=new Cookie("visitedTime", new Date().getMinutes()+"분");
		response.addCookie(cookie);
		
		request.setAttribute("greeting","hello world welcom to hell");
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	}


}
