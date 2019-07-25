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
 * �������ö��·�ɷ��ʹ���
 * @author Administrator
 *
 */
@WebServlet({"/D3","/User/d3","/TestD3/*"})
public class ServletDemo3 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���е��ֽڱ��붼��Ҫͳһ������������
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		
		String value1 = req.getParameter("UserName");
		System.out.println("UserName��"+value1);
		//���post�������������
//		BufferedReader br = req.getReader();
//		String line = null;
//		while((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
		//�õ����еĲ���
		Map<String, String[]> maps = req.getParameterMap();
		//�����õ�map��������м�
		Set<String> mapset = maps.keySet();
		for (String key : mapset) {
			String[] values = maps.get(key);
			System.out.println(key);
			for (String value : values) {
				System.out.println(value);
			}
			System.out.println("----------");
		}
		
		//�����ݽ��д����ת������һ��url
		req.setAttribute("msg", "��Դ��ת����");
		
		//��Դת����url���ᷢ���ı䣬���ǻ��ǻ��ָ����url���з��ʣ�����ֻʹ����һ������
		req.getRequestDispatcher("/Demo4").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("ip:"+req.getRemoteAddr());
//		System.out.println(req.getRequestURI());
		//this.doPost(req, resp);
	}
}
