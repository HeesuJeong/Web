package edu.ssafy.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.business.IMemService;
import edu.ssafy.business.MemServiceImpl;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMemService service =new MemServiceImpl();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// index.html에서 <a>태그에서 하이퍼링크 거는데!
		// <a>는 get방식이다!
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");

		if (action.equals("registmem")) {
			service.registMem(request, response);
		} else if (action.equals("listmem")) {
			service.listMem(request, response);
		} else if (action.equals("meminfo")) {
			service.mainInfo(request, response);
		} else if (action.equals("deletemem")) {
			service.deleteMem(request, response);
		} else if (action.equals("updatemem")) {
			service.updatemem(request, response);
		} else if (action.equals("login")) {
			service.logIn(request, response);
		}else if (action.equals("logOut")) {
			service.logOut(request, response);
		}

	}

}
