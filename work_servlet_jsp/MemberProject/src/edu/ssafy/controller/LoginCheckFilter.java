package edu.ssafy.controller;

//로그인 안 된 상태로 넘어온 애는 서블릿으로 전달 안 하고 다 리턴해버릴거야!
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
public class LoginCheckFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		String isLogin = (String) req.getSession().getAttribute("islogin");
		String id = (String) req.getSession().getAttribute("id");
		System.out.println(isLogin + "," + id);
		if (isLogin == null && id == null&&!action.equals("registmem")&&!action.equals("login")) {
			res.sendRedirect("login.html");
			return;
		} // 끝내버려서 서블릿으로 안 가

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
