package DecorateClassDemo;

public class RinPhoneDecorate extends PhoneDecorate {

	public RinPhoneDecorate(Phone phone) {
		super(phone);
	}
	@Override
	public void call() {
		System.out.println("�ֻ�������������");
		super.call();
	}
	

}
