package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoketionHandler implements InvocationHandler {

	private Object target;
	public MyInvoketionHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("´úÀí");
		return method.invoke(target, args);
	}

}
