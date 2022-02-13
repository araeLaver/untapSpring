package org.zerock.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// XML 대신 사용되는 클래스 
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{
	// 3개의 추상 메서드를 오버라이드 하도록 작성
	// 


	@Override
	// root-context.xml 대신 사용하는 클래스
	protected Class<?>[] getRootConfigClasses()
	{
		// TODO Auto-generated method stub
//		return null;
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
