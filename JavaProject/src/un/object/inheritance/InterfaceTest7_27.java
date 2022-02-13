package un.object.inheritance;

public class InterfaceTest7_27
{
	public static void main(String args[])
	{
		A a = new A();
		a.methodA(new B());
	}
}

class A
{
	// 인스턴스 생성 후 메서드 호출
	public void methodA(B b)
	{
		b.methodB();
	}
}

class B
{
	public void methodB()
	{
		System.out.println("methodB()");
	}
}

// 두 클래스간의 관계를 간접적으로 변경하기 위해서는 먼저 인터페이스를 이용해서 클래스B(Provider)의 선언과 구현을 분리해야 한다.

interface I
{
	public abstract void methodB();
}

class BB implements I
{
	public void methodB()
	{
		System.out.println("methodB in B class");
	}
}

class AA
{
	public void methodA(I i)
	{
		i.methodB();
	}
}