package Demos;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Demo1 implements ServletContextListener {
    /**
     * 监听ServletContext对象创建的，ServletContext对象服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param servletContextEvent
     */

    /**
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
