package FilterDemos;

import javax.servlet.*;//注意导入的包
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 所有的页面都将执行该过滤器
 * 也可以使用web.xml进行配置
 * 配置 dispatcherTypes可以对访问方式进行设置
 * 1.REQUEST:默认的，只有浏览器直接请求时才会被过滤器拦截
 * 2.FORWARD：转发时会被过滤器拦截
 * 3.INCLUDE：包含访问资源
 * 4.ERROR：错误的跳转资源
 * 5.ASYNC：异步访问时拦截
 */
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class Demo1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤方法，每次进入都会执行
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        //执行放行操作，否则请求将会被拦截
        filterChain.doFilter(servletRequest, servletResponse);
        /**
         * 执行流程为：先执行放行前的代码，再执行请求的地址，最后结束了才执行下面的这句输出“回来了”
         */
        System.out.println("回来了");
    }

    @Override
    public void destroy() {

    }
}
