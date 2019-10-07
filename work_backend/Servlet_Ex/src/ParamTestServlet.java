import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		if(Integer.parseInt(age)<20) {
			resp.sendRedirect("personInfo.html");
			return;
		}
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.print("<head>");
		pw.print("<meta charset='UTF-8'>");
		pw.print("</head>");
		pw.write("<body>");
		pw.write("paramTest�Դϴ�. �Ѱܹ��� �Ķ���ʹ� "+name+" "+age+"�Դϴ�.");
		pw.write("</body>");
		pw.write("</html>");
		pw.flush();
	}

}
