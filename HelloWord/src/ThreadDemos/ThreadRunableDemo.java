package ThreadDemos;

public class ThreadRunableDemo {

	public static void main(String[] args) {
		ThreadRunable myThread = new ThreadRunable();
		Thread td1 = new Thread(myThread,"����");
		Thread td2 = new Thread(myThread,"����");
		Thread td3 = new Thread(myThread,"����");
		td1.start();
		td2.start();
		td3.start();
	}

}
