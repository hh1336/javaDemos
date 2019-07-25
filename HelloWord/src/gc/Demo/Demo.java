package gc.Demo;

public class Demo {

	public static void main(String[] args) {
		Person p = new Person("уехЩ",18);
		System.out.println(p.toString());
		System.out.println("--------------");
		p = null;
		System.gc();
	}

}
