package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
// 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션
// @ComponentScan을 통해서 지정되어있는 @Component가 있는 클래스를 읽어 준다 / 클래스들을 객체로 생성해서 빈으로 관리해준다.
@Data
public class Restaurant
{

	@Setter(onMethod_ = @Autowired)
	// 자동으로 setChef()를 컴파일 시 생성
	// Setter에서 사용된 onMethod 속성은 생성되는 setChef()에 @Autowired 어노테이션을 추가하도록 한다.

	// setter 메서드를 만들어주는 역할
	// 속성 3가지을 부여할 수 있다.
	// 1. vaule - 접근 제한 속성을 의미 / 기본값은 lombokAccessLevel.PULBIC
	// 2. onMethod - 메서드에 추가할 어노테이션 지정 / 예저는 @Autowired라는 어노테이션 지정
	// JDK 버전별
	// JDK7 = @Setter(onMethod=@__({AnnotationGoHere}))
	// JDK8 = @Setter(onMethod_=@AnnotationsGoHere})
	// 3. onParam - setter 메서드의 파라미터에 어노테이션을 사용하는 경우에 적용한다.

	// @Data
	// --> @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor를 모두 결합한 형태
	// @Log4j
	// --> 로그 객체를 생성 / Log4j 설정을 이용하고, Log4j가 존재하지 않을 경우에는 @Log를 이용할 수 있다.
	//

	// Lombok Annotaion		/	@Setter, @Data, @Log4j
	// Spring Annotation	/	@Autowired, @Component
	// Test Annotaion		/	@RunWith, @ContextConfiguration, @Test

	// @Autowired는 스프링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시
	// 스프링은 @Autowired 어노테이션을 보고 스프링 내부에 관리되는 객체 중에 적당한 것이 있는 지 확인하고 자동으로 주입해 준다.

	// Chef클래스에 @Component가 없다면 스프링은 Chef 객체를 스프링에서 관리하지 않게 된다.

	// 테스트 관련해서 가장 중요한 어노테이션은 @ContextConfiguration 이다.
	// @ContextConfiguration 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지를 명시한다.
	// 속성으로는 locations를 이용해서 문자열의 배열로 XML 설정 파일을 명시할 수도 있고, classes 속성으로 @Configuration이 적용된 클래스를 지정해 줄 수 있다.

	// @Runwith는 테스트 시 필요한 클래스를 지정한다.
	// 스프링은 SpringJUnit4ClassRunner 클래스가 대상이 된다.

	// @Test는 junit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상인지 알려준다.
	private Chef chef;

}

