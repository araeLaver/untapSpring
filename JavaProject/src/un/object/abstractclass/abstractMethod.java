package un.object.abstractclass;

public class abstractMethod
{
//	주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다.
//	추상메서드는 구현부가 없으므로 괄호{} 대신 문장의 끝을 알리는 ';'을 적어준다.
//	abstract 리턴타입 메서드이름();

	abstract class Player	// 추상클래스
	{
		abstract void play(int pos);	// 추상메서드
		abstract void stop();			// 추상메서드
	}

	// 자손클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 모두 구현
	class AudioPlayer extends Player
	{
		void play(int pos) {/* 내용생략 */}			// 추상메서드를 구현
		void stop() {/* 내용생략 */}					// 추상메서드를 구현
	}

	// 조상으로부터 상속받은 추상메서드 중 하나라로 구현하지 않는다면, 자손클래스 역시 추상클래스로 지정
	abstract class AbstractPlayer extends Player
	{
		void play(int pos) {/* 내용생략 */}			// 추상메서드를 구현
	}
}
