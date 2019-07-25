import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 可以配置多个路由访问规则
 * @author Administrator
 *
 */
@WebServlet({"/D3","/User/d3","/TestD3/*"})
public class ServletDemo3 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//所有的字节编码都需要统一，包括编译器
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		
		String value1 = req.getParameter("UserName");
		System.out.println("UserName："+value1);
		//获得post请求体参数内容
//		BufferedReader br = req.getReader();
//		String line = null;
//		while((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
		//得到所有的参数
		Map<String, String[]> maps = req.getParameterMap();
		//遍历得到map里面的所有键
		Set<String> mapset = maps.keySet();
		for (String key : mapset) {
			String[] values = maps.get(key);
			System.out.println(key);
			for (String value : values) {
				System.out.println(value);
			}
			System.out.println("----------");
		}
		
		//将数据进行处理后转发到下一个url
		req.setAttribute("msg", "资源被转发了");
		
		//资源转发，url不会发生改变，但是还是会对指定的url进行访问，并且只使用了一次请求
		req.getRequestDispatcher("/Demo4").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("ip:"+req.getRemoteAddr());
//		System.out.println(req.getRequestURI());
		//this.doPost(req, resp);
	}
}
