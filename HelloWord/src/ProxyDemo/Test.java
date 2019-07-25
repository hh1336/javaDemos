package ProxyDemo;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		UserDao ud = new UserDaoImp();
		ud.show();
		
		System.out.println("-----");
		MyInvoketionHandler handler = new MyInvoketionHandler(ud);
		UserDao proxy = (UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(),
				ud.getClass().getInterfaces(), handler);
		proxy.show();
	}

}
