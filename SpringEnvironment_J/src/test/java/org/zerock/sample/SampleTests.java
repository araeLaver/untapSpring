
package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 코드 표시
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests
{
	@Setter(onMethod_ = { @Autowired })
	// setter 메서드를 만들어주는 역할
	private Restaurant restaurant;

	@Test
	public void testExist()
	{
		assertNotNull(restaurant);

		log.info(restaurant);
		log.info("==================================");
		log.info("----------------------------------");
		log.info("==================================");
		log.info(restaurant.getChef());
	}
}

// Lombok Annotaion		/	@Setter, @Data, @Log4j
// Spring Annotation	/	@Autowired, @Component
// Test Annotaion		/	@RunWith, @ContextConfiguration, @Test




//@Log
//public class LogExample
//{
//}


//클래스로 변환된 후


//public class LogExample
//{
//	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
//}


