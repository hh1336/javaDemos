package NetDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) {
		try {
//			�õ�һ�������Ķ���
			InetAddress address = InetAddress.getByName("120.78.198.92");
//			�õ�������
			String name = address.getHostName();
//			�õ�������ַ
			String ip = address.getHostAddress();
			System.out.println(name + "-----" + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
