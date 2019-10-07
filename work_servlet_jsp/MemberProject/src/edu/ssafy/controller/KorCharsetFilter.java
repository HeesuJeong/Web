package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class KorCharsetFilter
 */
public class KorCharsetFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//브라우에서 서블릿으로 가는 쪽
		//main.do실행될때 무조건 이 함수 걸쳐지므로 매 함수마다 utf-8안 해줘도 돼!!!
		//즉 request.setCha~ response.set~ 이런거 안 해줘도 돼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		chain.doFilter(request, response);
		//서블릿에서 브라우저 방향
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
