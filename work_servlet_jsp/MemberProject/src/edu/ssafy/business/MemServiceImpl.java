package edu.ssafy.business;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

public class MemServiceImpl implements IMemService{

	private IMemManager man=new MemManagerImpl();
	public MemServiceImpl() {
	}
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//세션 지우면 돼 => 세션 모두 초기화돼
		request.getSession().invalidate();
		response.sendRedirect("login.html");
		//islogin만 null로 초기화
		//request.getSession().setAttribute("islogin", null);
		
		//쿠키
		/*Cookie[] cookies=request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			cookies[i].getName();
			cookies[i].getValue();
			cookies[i].setMaxAge(0);
		}
		response.sendRedirect("login.html");*/
	}

	public void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		boolean isLogin = man.isLogin(id, pw);
		if (isLogin) {
			//세션
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
			response.sendRedirect("main.do?action=listmem");
			request.getSession().setAttribute("islogin", "isLogin");
			request.getSession().setAttribute("id",id);
			
			//쿠키
			/*Cookie cooklogin = new Cookie("islogin",isLogin+"");
			Cookie cookid = new Cookie("islogin",id);
			response.addCookie(cooklogin);
			response.addCookie(cookid);
			 response.sendRedirect("main.do?action=listmem");*/
		} else {
			response.sendRedirect("login.html");
		}
	}

	public void updatemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		boolean update = man.updateMem(id, name, pw, addr, age, tel);
		if (update) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 수정이 실패하였습니");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void deleteMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		boolean del = man.delMem(id);
		if (del) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 삭제를 실패하였습니다");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void mainInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 키값 uid의 값 가져와
		String id = request.getParameter("uid");
		MemVO mem = man.memInfo(id);
		System.out.println(mem.toString());
		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MemVO> list = man.getList();
		// 화면구성은 jsp로!
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void registMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 2.파라미터 작업(name 속성 쫓는다)

		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		// 파라미터는 무조건 문자열로 주고받아진다
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		// 3
		boolean res = man.addMem(id, name, pw, addr, age, tel);
		// 4
		if (res) {
			// request.setAttribute("result", id+"등록성공");
			// request.getSession().setAttribute("result", id+"등록성공");
			
			
			String msg = URLEncoder.encode(id+"등록성공", "UTF-8");
			response.sendRedirect("result.jsp?result=" + msg);
		} else {
			// request.setAttribute("result", id+"등록실패");
			String msg = URLEncoder.encode(id+"등록실패", "UTF-8");
			response.sendRedirect("result.jsp?result=" + msg);
		}
		// request.getRequestDispatcher("result.jsp").forward(request, response);
	}
	
	
}
