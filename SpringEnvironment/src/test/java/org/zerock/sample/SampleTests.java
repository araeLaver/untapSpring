
package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 코드 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// 어노테이션과 속성값인 문자열 설정이 중요한 설정
// 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록하게 된다.(스프링의 빈으로 등록)
// 사용하는 문자열은 ''classpath:'나 'file:'을 이용할수 있으므로, 이클립스에서 자동의로 생성된 root-context.xml의 경로를 지정 할 수 있다.
@Log4j
// Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성한다.
public class SampleTests
{
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;

	@Test
	// JUnit에서 테스트 대상을 표시하는 어노테이션이다.
	public void testExist()
	{
		assertNotNull(restaurant);
		// asserNotNull()은 restaurant 변수가 null이 아니어야만 테스트가 성공한다는 것을 의미

		log.info(restaurant);
		log.info("==================================");
		log.info("----------------------------------");
		log.info("==================================");
		log.info(restaurant.getChef());
	}
}

// new Restaurant()와 같이 Restaurant 클래스에서 객체를 생성한 적이 없는데도 객체가 만들어졌다는 점
// 스프링은 관리가 필요한 Bean를 어노테이션 등을 이용해서 객체를 생성하고 관리하는 일종의 '컨테이너' 나 '팩토리' 의 기능을 가지고 있다.
//
// Restaurant 클래스의 @Data 어노테이션으로 Lmobok을 이용해서 여러 메서드가 만들어진 점
// Lombok은 자동으로 getter/setter 등을 만들어 주는데 스프링은 생성자 주입 혹은 setter 주입을 이용해서 동작한다.
// getter/setter 등을 자동으로 생성하고, 'onMethod' 속성을 이용해서 작성된 setter에 @Autowired 어노테이션을 추가 한다.
//
// Restaurant 객체의 Chef 인스턴스 변수(멤버 변수)에 Chef 타입의 객체가 주입되어 있다는 점
// @Autowired과 같은 어노테이션을 이용해서 개발자가 직접 객체들과의 관계를 관리하지 않고, 자동으로 관리도도록 한다.
