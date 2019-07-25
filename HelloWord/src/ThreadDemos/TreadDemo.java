package ThreadDemos;

public class TreadDemo {

	public static void main(String[] args) {
		MyThreadDemo mtd = new MyThreadDemo();
		MyThreadDemo mtd2 = new MyThreadDemo();

		mtd.setName("张三");
		mtd2.setName("李四");

//		优先级
		mtd2.setPriority(5);

		mtd.start();

//		// 等待
//		try {
//			mtd2.join();
//			// 中止线程
		mtd.interrupt();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		
		mtd2.start();

		Thread.currentThread().setName("主线程");
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
