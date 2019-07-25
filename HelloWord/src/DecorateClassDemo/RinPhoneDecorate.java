package DecorateClassDemo;

public class RinPhoneDecorate extends PhoneDecorate {

	public RinPhoneDecorate(Phone phone) {
		super(phone);
	}
	@Override
	public void call() {
		System.out.println("手机可以听彩铃了");
		super.call();
	}
	

}
