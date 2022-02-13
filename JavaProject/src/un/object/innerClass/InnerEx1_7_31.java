package un.object.innerClass;

public class InnerEx1_7_31
{
	class InstanceInner
	{
		int iv = 100;
//		static int cv = 100;			// error - static변수를 선언할 수 없다.
		final static int CONST = 100;	// final static은 상수이므로 허용한다.
	}

	static class StaticInner
	{
		int iv = 200;
		static int cv = 200;			// static 클래스만 static멤버를 정의할 수 있다.
	}

	void myMethod()
	{
		class LocalInner
		{
			int iv = 300;
//			static int cv = 300;			// error - static변수를 선언할 수 없다.
			final static int CONST = 300;	// final static은 상수이므로 허용한다.
		}
	}

	public static void main(String args[])
	{
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}

// 내부 클래스 중에서 StaticInner만 static멤버를 가질 수 있다. 내부 클래스에 static변수를 선언해한다면 스태틱 클래스로 선언해야한다.
// 다만 final과 static이 동시에 붙은 변수는 상수(constant)이므로 모든 내부 클래스에서 정의가 가능하다.