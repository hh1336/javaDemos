package DieLockDemo;

public class DieLock extends Thread {
	private Boolean flag;

	public DieLock(Boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		if(this.flag) {
			synchronized (MyLock.objA) {
				System.out.println("进入if objA");
				synchronized (MyLock.objB) {
					System.out.println("进入if objB");
				}
			}
		}else {
			synchronized (MyLock.objB) {
				System.out.println("进入else objB");
				synchronized (MyLock.objA) {
					System.out.println("进入else objA");
				}
			}
		}
	}
}
