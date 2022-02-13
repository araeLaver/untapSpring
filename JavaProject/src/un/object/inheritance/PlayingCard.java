package un.object.inheritance;

public interface PlayingCard
{
//	7.2 인터페이스의 작성
	public static final int SPACE = 4;

	final int DIAMOND = 3;		// public static final int DIAMOND = 3;
	static int HEART = 2;		// public static final int HEART = 2;
	int CLOVER = 1;				// public static final int CLOVER = 1;

	public abstract String getCarNumber();
	String getCarKind();		// public abstract String getCardKind();

//	7.3 인터페이스의 상속
	interface Movable
	{
		// 지정된 위치(x, y)로 이동하는 기능의 메서드
		void move(int x, int y);
	}

	interface Attackable
	{
//		void attack(Unit u);
	}

	interface Fightable extends Movable, Attackable {}


//	class Fighter extends Unit implements Fightable
//	{
//		public void move(int x, int y) {}
//		public void attack(Unit u) {}
//	}
}
