package h.firstPackage;

//һ������
public class Person implements IPerson {
	public String name;
	public final int age;
	public double salery;

	public Person(String name, double salery) {
		this.name = name;
		this.salery = salery;
		this.age = 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public void Eat() {

		System.out.println(this.name + "Eat");

	}

	@Override
	public void Sleep() {

		System.out.println(this.name + "Sleep");
	}

	public void ShowSalery() {
		System.out.println(this.name + "�Ĺ���Ϊ��" + this.salery+"Ԫ");
	}

}
