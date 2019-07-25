package EnumDemos;

public enum Direction {
//	TOP,BUTTOM;//��ͨ��ʽ
	// ��������ö��
//	TOP("��"),BUTTOM("��");//�޳��󷽷���ö��

	// �г��󷽷���ö��
	TOP("��") {
		@Override
		public void show() {
			System.out.println(this.getName());

		}
	},
	BUTTOM("��") {
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
