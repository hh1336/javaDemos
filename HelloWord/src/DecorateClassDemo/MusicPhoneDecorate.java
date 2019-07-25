package DecorateClassDemo;

public class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone phone) {
		super(phone);
	}
	@Override
	public void call() {
		System.out.println("ø…“‘Ã˝“Ù¿÷¡À");
		super.call();
	}

}
