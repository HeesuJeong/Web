package edu.ssafy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//session.do
public class sessionTestServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//request객체로 부터 세션 객체를 생성한다
		HttpSession session=request.getSession(true);
	
	PrintWriter out=response.getWriter();
	//세션이 처음으로 생성된 것인지 체크
	if(session.isNew()) {
		//세션이 최초에 생성된 시점에 호출되어짐
		out.println("NEW <br/>");
		out.println("Session ID: "+session.getId()); //세션 아이디 가져오기
		out.println("생성시간: "+new Date(session.getCreationTime()));
		out.println("최근접근시간: "+new Date(session.getLastAccessedTime()));
		//세션 타임아웃시간 조회
		out.println("Max Inactive Interval:"+session.getMaxInactiveInterval());
		//세션 타임아웃 시간 1200초로 설정
		session.setMaxInactiveInterval(1200);
	}else {
		//세션 생성후의 요청일 때 호출되어짐
		out.println("OLD session <br/>");
		out.println("session ID: "+session.getId());
		out.println("생성시간:"+new Date(session.getCreationTime()));
		out.println("최근접근시간: "+new Date(session.getLastAccessedTime()));
		out.println("Max Inactive Interval:"+session.getMaxInactiveInterval());
	}
	}

}
