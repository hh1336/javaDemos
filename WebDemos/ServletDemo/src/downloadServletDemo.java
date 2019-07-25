import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadServlet3")
public class downloadServletDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		//�õ�������ļ���
		String filename = req.getParameter("filename");
		//�����ļ���ȥ��������Ӧ·���ҵ���Ӧ�ļ�
		String filepath = sc.getRealPath("/"+filename);
		//�����ļ������ڴ�
		FileInputStream fis = new FileInputStream(filepath);
		
		//��ȡ�ļ���mime����
		String mimeType = sc.getMimeType(filename);
		resp.setContentType(mimeType);//������Ӧͷ����
		
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		
		//��ȡ�����
		ServletOutputStream sos = resp.getOutputStream();
		//���ڵ����ַ�������
		byte[] buff = new byte[1024 * 8];
		int len = 0;
		//���ļ���ȡ���������У����Ҽ�¼����
		while((len = fis.read(buff))!= -1) {
			//�����ص����������ļ�д��������У���0-len�ĳ���
			sos.write(buff,0,len);
		}
		fis.close();
	}
}
