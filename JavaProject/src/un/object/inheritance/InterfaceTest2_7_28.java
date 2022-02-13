package un.object.inheritance;

public class InterfaceTest2_7_28
{
	public static void main(String[] args)
	{
		AAA a = new AAA();
		a.autoPlay(new BBB());
		a.autoPlay(new CCC());
	}

}

interface II
{
	public abstract void play();
}

class AAA
{
	void autoPlay(II i)
	{
		i.play();
	}
}

class BBB implements II
{
	public void play()
	{
		System.out.println("play in B class");
	}
}

class CCC implements II
{
	public void play()
	{
		System.out.println("play in C Class");
	}
}

// 클래스 Thread의 생성자인 Thread(Runnable targer) 방식
// 매개변수를 통해서 인터페이스를 구현한 클래스의 인스턴스를 동적으로 제공
// 제3의 클래스를 통해서 제공받을 수 있다. -> JDBC의 DriverManager클래스