package un.object.inheritance;

public class Interface7_5
{
	public class Tv
	{
		protected boolean power;
		protected int channel;
		protected int volume;

		public void power()			{power =! power;}
		public void channelUp()		{channel++;}
		public void channelDown()	{channel--;}
		public void volumeUp()		{volume++;}
		public void volumeDown()	{volume--;}
	}

	public class VCR
	{
		protected int counter;

		public void play()
		{

		}

		public void stop()
		{

		}
		public void reset()
		{
			counter = 0;
		}

		public int getCounter()
		{
			return counter;
		}

		public void setCounter(int c)
		{
			counter = c;
		}
	}

	// VCR클래스에 정의된 메서드와 일치하는 추상메서드를 갖는 인터페이스를 작성한다.
	public interface IVCR
	{
		public void play();
		public void stop();
		public void reset();
		public int getCounter();
		public void setCounter(int c);
	}

//	IVCR 인터페이스를 구현하고, Tv클래스로부터 상속 TVCR클래스를 작성한다.
//	VCR클래스 타입의 참조변수를 멤버변수로 선언하여 IVCR인터페이스와 추상메서드를 구현하는데 사용한다.
	public class TVCR extends Tv implements IVCR
	{
		VCR vcr = new VCR();

		public void play()
		{
			vcr.play();
		}

		public void stop()
		{
			vcr.stop();
		}
		public void reset()
		{
			vcr.reset();;
		}

		public int getCounter()
		{
			return vcr.getCounter();
		}

		public void setCounter(int c)
		{
			vcr.setCounter(c);
		}
	}
}
