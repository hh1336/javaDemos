import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadServlet")
public class ServletContextDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setCharacterEncoding("GBK");
//		//��ȡServletContext����
//		ServletContext sc = this.getServletContext();
//		ServletContext sc2 = req.getServletContext();
//		
//		//��ȡ��ԴĿ¼
//		String jsppath = sc.getRealPath("/index.jsp");
//		System.out.println(jsppath);
	}
}
