package FirstPackage;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServerletDemo1 implements Servlet {

	/**
	 * ���ٷ������ڷ����������ر�ʱִ��һ��
	 */
	@Override
	public void destroy() {
		
		
	}

	/***
	 * ������ȡServlet���ö���
	 */
	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	/**
	 * ������ȡһЩServlet��Ϣ
	 */
	@Override
	public String getServletInfo() {
		
		return null;
	}

	/***
	 * ��ʼ����������Servlet���������ֻ���ڴ���ʱִ��һ�� 
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		
	} 

	/***
	 * �ṩ�ķ��񷽷���Servletÿ�α�����ʱ����ִ���������
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Hello");
	}
}
