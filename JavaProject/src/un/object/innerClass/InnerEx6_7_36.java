package un.object.innerClass;

public class InnerEx6_7_36
{
	Object iv = new Object() { void method() {} };			// 익명클래스
	static Object cv = new Object() { void method() {} };	// 익명클래스

	void myMethod()
	{
		Object iv = new Object() { void method() {} };		// 익명클래스
	}
}
