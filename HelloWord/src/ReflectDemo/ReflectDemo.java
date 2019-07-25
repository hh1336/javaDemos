package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectDemo {

	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Person p = new Person();
		Class c = p.getClass();

		Person p2 = new Person();
		Class c2 = p2.getClass();
		System.out.println(c2 == c);

		Class c3 = Person.class;
		System.out.println(c2 == c3);
		Class c4 = Class.forName("ReflectDemo.Person");
		System.out.println(c == c4);

//		获取构造函数
//		Constructor[] cons = c.getConstructors();//得到公共的构造方法
//		Constructor[] cons = c.getDeclaredConstructors();//得到所有构造方法
//		for (Constructor constructor : cons) {
//			System.out.println(constructor);
//		}
//		获取单个构造方法
//		Constructor con = c.getConstructor();
//		Object obj = con.newInstance();
//		获取带参数的构造方法
//		Constructor con = c.getConstructor(String.class,int.class,String.class);
//		Object obj = con.newInstance("张三",13,"北京");
//		System.out.println(obj);
//		获取私有的构造方法
//		Constructor con = c.getDeclaredConstructor(String.class,int.class);
//		//允许访问私有构造方法
//		con.setAccessible(true);
//		Object obj = con.newInstance("张三",13);
//		System.out.println(obj);
//		获取所有成员变量
//		Field[] fds = c.getFields();//获取公共的成员变量
//		Field[] fds = c.getDeclaredFields();//获取包括私有的所有成员变量
//		for (Field field : fds) {
//			System.out.println(field);
//		}
//		获取单个成员变量
//		Field address = c.getField("address");//获取一个成员变量
//		Constructor con = c.getConstructor();//得到无参构造函数
//		Object obj = con.newInstance();//通过无参构造函数创建实例
//		address.set(obj, "地址");//为这个实例的字段赋值
//		System.out.println(obj);
//		调用方法
		Method m1 = c.getMethod("getString",String.class,int.class);
		Object result = m1.invoke(c.getConstructor().newInstance(),"张三",10);
		System.out.println(result);
	}

}
