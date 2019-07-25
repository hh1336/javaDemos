package NetDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientDemo {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1",10086);
		
		OutputStream os = s.getOutputStream();
		os.write("Œ“¿¥¡À".getBytes());
		
		s.close();
	}
}
