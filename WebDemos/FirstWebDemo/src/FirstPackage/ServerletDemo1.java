package FirstPackage;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServerletDemo1 implements Servlet {

	/**
	 * 销毁方法，在服务器正常关闭时执行一次
	 */
	@Override
	public void destroy() {
		
		
	}

	/***
	 * 用来获取Servlet配置对象
	 */
	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	/**
	 * 用来获取一些Servlet信息
	 */
	@Override
	public String getServletInfo() {
		
		return null;
	}

	/***
	 * 初始化方法，在Servlet中这个方法只会在创建时执行一次 
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		
	} 

	/***
	 * 提供的服务方法，Servlet每次被访问时都会执行这个方法
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Hello");
	}
}
