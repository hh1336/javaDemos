package NetDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
	public static void main(String[] args) throws IOException {
//		开启端口服务
		ServerSocket ss = new ServerSocket(10086);
//		得到连接的socket
		Socket s = ss.accept();
//		定义数据来接收
		byte[] bys = new byte[1024];
//		如果有客户端连接进入就将内容转换并且打印到控制台
		System.out.println(new String(bys, 0, s.getInputStream().read(bys)));
		s.close();
		ss.close();
	}
}
