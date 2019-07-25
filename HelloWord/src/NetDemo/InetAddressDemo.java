package NetDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) {
		try {
//			得到一个主机的对象
			InetAddress address = InetAddress.getByName("120.78.198.92");
//			得到主机名
			String name = address.getHostName();
//			得到主机地址
			String ip = address.getHostAddress();
			System.out.println(name + "-----" + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
