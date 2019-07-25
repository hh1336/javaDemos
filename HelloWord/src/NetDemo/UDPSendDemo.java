package NetDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSendDemo {
	public static void main(String[] args) throws IOException {
//		创建传输对象
		DatagramSocket ds = new DatagramSocket();
		byte[] bys = "Hello".getBytes();
		int length = bys.length;
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		DatagramPacket dp = new DatagramPacket(bys, length, address, port);
		ds.send(dp);
		ds.close();
	}
}
