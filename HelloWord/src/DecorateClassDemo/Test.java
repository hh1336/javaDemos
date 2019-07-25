package DecorateClassDemo;

public class Test {

	public static void main(String[] args) {
		PhoneDecorate pd = new RinPhoneDecorate(new MusicPhoneDecorate(new IPhoneImp()));
		pd.call();

	}

}
