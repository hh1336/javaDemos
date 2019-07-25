package ThreadDemos;

public class ThreadRunableDemo {

	public static void main(String[] args) {
		ThreadRunable myThread = new ThreadRunable();
		Thread td1 = new Thread(myThread,"张三");
		Thread td2 = new Thread(myThread,"李四");
		Thread td3 = new Thread(myThread,"王五");
		td1.start();
		td2.start();
		td3.start();
	}

}
