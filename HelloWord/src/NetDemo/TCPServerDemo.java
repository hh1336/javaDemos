package NetDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
	public static void main(String[] args) throws IOException {
//		�����˿ڷ���
		ServerSocket ss = new ServerSocket(10086);
//		�õ����ӵ�socket
		Socket s = ss.accept();
//		��������������
		byte[] bys = new byte[1024];
//		����пͻ������ӽ���ͽ�����ת�����Ҵ�ӡ������̨
		System.out.println(new String(bys, 0, s.getInputStream().read(bys)));
		s.close();
		ss.close();
	}
}
