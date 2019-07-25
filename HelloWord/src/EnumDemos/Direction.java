package EnumDemos;

public enum Direction {
//	TOP,BUTTOM;//普通方式
	// 带方法的枚举
//	TOP("上"),BUTTOM("下");//无抽象方法的枚举

	// 有抽象方法的枚举
	TOP("上") {
		@Override
		public void show() {
			System.out.println(this.getName());

		}
	},
	BUTTOM("下") {
		@Override
		public void show() {
			System.out.println(this.getName());
		}
	};

	private String name;

	private Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void show();
}
