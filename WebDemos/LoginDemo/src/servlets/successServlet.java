package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Account;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account account = (Account)req.getAttribute("account");
		resp.setContentType("text/html;charset=GBK");
		if(account == null) {
			req.getRequestDispatcher("/failServlet").forward(req, resp);
			return ;
		}
		resp.getWriter().write("µÇÂ½³É¹¦£¬»¶Ó­Äã"+account.getUsername());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
