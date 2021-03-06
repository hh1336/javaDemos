package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器，处理编码格式
 */
public class CharchaterFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String method = request.getMethod();
        if(method.equalsIgnoreCase("post")){
            request.setCharacterEncoding("utf-8");
        }
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request,response);
    }

    public void destroy() {

    }
}
