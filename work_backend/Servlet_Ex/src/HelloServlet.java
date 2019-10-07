import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		resp.setCharacterEncoding("UTF-8");
		
		
		
		PrintWriter out=resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>hello world</h1><p><p>현재시간 - ");
		Calendar today=Calendar.getInstance();
		out.print(today.get(Calendar.HOUR_OF_DAY));
		out.print(":");
		out.print(today.get(Calendar.SECOND));
		out.print("</p> </body>");
		out.print("</html>");
		out.close();
	}

}
