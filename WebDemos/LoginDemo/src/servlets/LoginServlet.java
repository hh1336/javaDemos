package servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.AccountDao;
import domain.Account;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		Account account = new Account();
//		account.setUsername(username);
//		account.setPassword(password);
		
		Map<String,String[]> map = req.getParameterMap();
		try {
			//使用BeanUtils可以对map对象进行自动映射
			//使用 org.apache.commons.beanutils.BeanUtils; 
			BeanUtils.populate(account, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		AccountDao acd = new AccountDao();
		Account result = acd.Login(account);
		if(result == null) {
			req.getRequestDispatcher("/failServlet").forward(req, resp);
		}else {
			req.setAttribute("account", result);
			req.getRequestDispatcher("/successServlet").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
