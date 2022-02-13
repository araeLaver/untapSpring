package un.object.inheritance;

public class InterfaceTest3_7_29
{
	public static void main(String[] args)
	{
		AAAA a = new AAAA();
		a.methodA();
	}
}

interface IIII
{
	public abstract void methodB();
}

class InstanceManager
{
	public static IIII getInstance()
	{
		return new BBBB();				// 다른 인스턴스로 바꾸려면 여기만 변경하면 됨.
	}
}

class AAAA
{
	void methodA()
	{
		IIII i = InstanceManager.getInstance();	// 제3의 클래스의 메서드를 통해서 인터페이스 I를 구현한클래스의 인스턴스를 얻어온다.
		i.methodB();
		System.out.println(i.toString());		// i로 Object의 메서드 호출 가능
	}
}

class BBBB implements IIII
{
	public void methodB()
	{
		System.out.println("methodB in B class");
	}

	public String toString() {return "class b";}
}

