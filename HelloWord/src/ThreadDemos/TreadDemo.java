package ThreadDemos;

public class TreadDemo {

	public static void main(String[] args) {
		MyThreadDemo mtd = new MyThreadDemo();
		MyThreadDemo mtd2 = new MyThreadDemo();

		mtd.setName("����");
		mtd2.setName("����");

//		���ȼ�
		mtd2.setPriority(5);

		mtd.start();

//		// �ȴ�
//		try {
//			mtd2.join();
//			// ��ֹ�߳�
		mtd.interrupt();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		
		mtd2.start();

		Thread.currentThread().setName("���߳�");
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
