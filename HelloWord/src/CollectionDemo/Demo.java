package CollectionDemo;

import java.util.*;

import gc.Demo.Person;


public class Demo {

	public static void main(String[] args) {
		List<Person> p = new ArrayList<Person>();
		p.add(new Person("уехЩ",18));
		p.add(new Person("lisis",123));
		System.out.println(p);
		for (Person ps : p) {
			System.out.println(ps.name+"+"+ps.age);
		}
	}

}
