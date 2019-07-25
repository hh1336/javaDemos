package DieLockDemo;

public class DieLockDemo {
	public static void main(String[] args) {
		DieLock dielock = new DieLock(true);
		DieLock dielock2 = new DieLock(false);
		
		dielock.start();
		dielock2.start();
	}
}
