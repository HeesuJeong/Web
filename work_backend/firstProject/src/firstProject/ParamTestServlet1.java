package firstProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param1.do")
public class ParamTestServlet1 extends HttpServlet{
private static final long serialVersionUID=1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String text=req.getParameter("text");
	String password=req.getParameter("password");
	String habby[]=req.getParameterValues("habby");
	String job[]=req.getParameterValues("job");
	String content=req.getParameter("content");
	String gender=req.getParameter("gender");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out=resp.getWriter();
	out.print("<!DOCTYPE html>");
	out.print("<html>");
	out.print("<head>");
	out.print("<meta charset='UTF-8'>");
	out.print("<title>Insert title here</title>");
	out.print("</head>");
	out.print("<body>");
	out.print("<h1>전송된 데이터</h1><p>");
	out.print("<br/>text:"+text);
	out.print("<br/>password:"+password);
	if(habby!=null) {
		out.print("<br/>hobby:");
		for(String h:habby) {
			out.print(h+" ");
		}
	}
	out.print("<br/>job:");
	for(String j:job) {
		out.print(j+" ");
	}
	out.print("<br/>content:"+content);
	out.print("<br/>gender:"+gender);
	out.print(gender);
	out.print("</body>");
	out.print("</html>");
}


}
