package ThreadDemos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadRunable implements Runnable {

	private int count = 100;
//	private Object loca = new Object();
	private Lock lock = new ReentrantLock();
	private Boolean status = true;

//	@Override
//	public void run() {
//		while (status) {
//			synchronized (loca) {
//				if (count > 0) {
//					System.out.println(Thread.currentThread().getName() + " 抢到了：" + (count--) + "号");
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						System.out.println(Thread.currentThread().getName() + "休息中");
//					}
//				} else {
//					status = false;
//				}
//			}
//		}
//
//	}
	@Override
	public void run() {
		while (status) {
			try {
				lock.lock();
				if (count > 0) {
					System.out.println(Thread.currentThread().getName() + " 抢到了：" + (count--) + "号");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() + "休息中");
					}
				} else {
					status = false;
				}
			} finally {
				lock.unlock();
			}	
		}
	}

}
