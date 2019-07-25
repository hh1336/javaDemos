package ThreadDemos;

public class MyThreadDemo extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				System.out.println("Ë¯×ÅÁË");
//			}
			System.out.println(i+":"+this.getName());
		}
	}
}
