package edu.dispatch;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.Manager;
/**
 * Servlet implementation class JoinServlet
 */
public class JoinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Manager dao=Manager.getInstance();
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    //매번 초기화되기때문에 저장할 클래스 별도로 존재해야한다.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.한글처리
        request.setCharacterEncoding("utf-8");
        //2.파라미터처리
        String id = request.getParameter("pid");
        String passwd = request.getParameter("ppasswd");
        String name = request.getParameter("pname");
        
        if(dao.addManber(id, name, passwd)){
        	request.setAttribute("msg", "id: "+id+" 는 등록성공되었습니다");
        	request.getRequestDispatcher("success.jsp").forward(request, response);
        }else {
        	response.sendRedirect("join.jsp");
        }
    }
}
