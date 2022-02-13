package un.object.abstractclass;

public class abstractMethod2
{
	abstract class Player		// 추상클래스
	{
		boolean pause;			// 일시정지 상태를 저장하기 위한 변
		int currentPos;			// 현재 Play되고 있는 위치를 저장하기 위한 변수

		Player()
		{
			pause = false;		// 추상클래스도 생성자가 있어야 한다.
			currentPos = 0;
		}

		// 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다.
		abstract void play(int pos);	// 추상메서드
		// 재생을 즉시 멈추는 기능을 수행하도록 자성되어야 한다.
		abstract void stop();			// 추상메서드

		void play()
		{
			play(currentPos);			// 추상메서드를 사용할 수 있다.
		}

		void pause()
		{
			if (pause)					// pause가 true일때(정지상태)에서 pause가 호출되면,
			{
				pause = false;			// pause의 상태를 false로 바꾸고,
				play(currentPos);		// 현재의 위치에서 play를 한다.
			}
			else						// pause가 false일때(play상태)에서 pause가 호출되면,
			{
				pause = true;			// pause의 상태를 true로 바꾸고,
				stop();					// play를 멈춘다.
			}
		}
	}

	// Player클래스를 조상으로하는 CDPlayer 클래스 생성
	class CDPlayer extends Player
	{
		void play(int currnetPos)
		{
//			조상의 추상메서드를 구현.
		}

		void stop()
		{
//			조상의 추상메서드를 구현.
		}

		// CDPlayer 클래스에 추가로 정의된 멤버
		int currentTrack;	// 현재 재생 중인 트랙

		void nextTrack()
		{
			currentTrack++;
		}

		void preTrack()
		{
			if(currentTrack > 1)
			{
				currentTrack--;
			}
		}
	}


// 기존 클래스에서 공통된 부분을 뽑아내어 추상클래스 생성
	class Marine
	{
		int x, y;
		void move(int x, int y) {}
		void stop() {}
		void stimPack() {}
	}

	class Tank
	{
		int x, y;
		void move(int x, int y) {}
		void stop() {}
		void changeMode() {}
	}

	class Dropship
	{
		int x, y;
		void move(int x, int y) {}
		void stop() {}
		void load() {}
		void unload() {}
	}

//  공통부분 추출
	abstract class Unit
	{
		int x, y;
		abstract void move(int x, int y);
		void stop() {}
	}

	class Marine2 extends Unit
	{
		void move(int x, int y) {}
		void stimPack() {}
	}

	class Tank2 extends Unit
	{
		void move(int x, int y) {}
		void changeMode() {}
	}

	class Dropship2 extends Unit
	{
		void move(int x, int y) {}
		void load() {}
		void unload() {}
	}

//	Unit[] group = new Unit[4];
//	group[0] = new Marine2();
//	group[1] = new Tank2();
//	group[2] = new Marine2();
//	group[3] = new Dropship2();

//	for(int i = 0; group.length; i ++)
//	{
//		group[i].move(100, 200);
//	}


}

