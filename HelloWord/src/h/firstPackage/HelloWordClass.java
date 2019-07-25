package h.firstPackage;

public class HelloWordClass {

	public static void main(String[] args) {
		int a = 10;
		System.out.println("HelloWord");
		Person p = new Person("张三",3500d);
		System.out.println("创建了一个对象");
		p.Eat();
		p.Sleep();
		p.ShowSalery();
	}

}
