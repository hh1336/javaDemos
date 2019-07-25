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

//		��ȡ���캯��
//		Constructor[] cons = c.getConstructors();//�õ������Ĺ��췽��
//		Constructor[] cons = c.getDeclaredConstructors();//�õ����й��췽��
//		for (Constructor constructor : cons) {
//			System.out.println(constructor);
//		}
//		��ȡ�������췽��
//		Constructor con = c.getConstructor();
//		Object obj = con.newInstance();
//		��ȡ�������Ĺ��췽��
//		Constructor con = c.getConstructor(String.class,int.class,String.class);
//		Object obj = con.newInstance("����",13,"����");
//		System.out.println(obj);
//		��ȡ˽�еĹ��췽��
//		Constructor con = c.getDeclaredConstructor(String.class,int.class);
//		//�������˽�й��췽��
//		con.setAccessible(true);
//		Object obj = con.newInstance("����",13);
//		System.out.println(obj);
//		��ȡ���г�Ա����
//		Field[] fds = c.getFields();//��ȡ�����ĳ�Ա����
//		Field[] fds = c.getDeclaredFields();//��ȡ����˽�е����г�Ա����
//		for (Field field : fds) {
//			System.out.println(field);
//		}
//		��ȡ������Ա����
//		Field address = c.getField("address");//��ȡһ����Ա����
//		Constructor con = c.getConstructor();//�õ��޲ι��캯��
//		Object obj = con.newInstance();//ͨ���޲ι��캯������ʵ��
//		address.set(obj, "��ַ");//Ϊ���ʵ�����ֶθ�ֵ
//		System.out.println(obj);
//		���÷���
		Method m1 = c.getMethod("getString",String.class,int.class);
		Object result = m1.invoke(c.getConstructor().newInstance(),"����",10);
		System.out.println(result);
	}

}
