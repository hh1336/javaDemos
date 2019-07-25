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
		//得到传入的文件名
		String filename = req.getParameter("filename");
		//根据文件名去服务器对应路径找到对应文件
		String filepath = sc.getRealPath("/"+filename);
		//加载文件进入内存
		FileInputStream fis = new FileInputStream(filepath);
		
		//获取文件的mime类型
		String mimeType = sc.getMimeType(filename);
		resp.setContentType(mimeType);//设置响应头类型
		
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		
		//获取输出流
		ServletOutputStream sos = resp.getOutputStream();
		//用于当作字符缓冲区
		byte[] buff = new byte[1024 * 8];
		int len = 0;
		//将文件读取到缓冲区中，并且记录长度
		while((len = fis.read(buff))!= -1) {
			//将加载到缓冲区的文件写入输出流中，从0-len的长度
			sos.write(buff,0,len);
		}
		fis.close();
	}
}
