package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
// AOP(Aspect-Oriented-Programmin)를 이용한 방식
// 공통적인 예외사항에 대해서 분리하는 방식
// 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@Log4j
public class CommonExceptionAdvice
{
	@ExceptionHandler(Exception.class)
	// 해당 메서드가 () 들어가는 예외 타입을 처리한다는 것을 의미
	// 속성으로는 Exception 클래스 타입을 지정할 수 있다. 모든 예외에 대한 처리가 except()만을 이용해서 처리할 수 있다.
	// 특정한 타입의 예외를 다루고 샆다면 Exception.class 대신에 구체적인 예외의 클래스를 지정해야 한다.
	// except()의 리턴값은 문자열이므로 JSP파일의 경로가 된다.
	public String except(Exception ex, Model model)
	{
		log.error("Exception ......." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	// 예외 메시지 구성
	public String handle404(NoHandlerFoundException ex)
	{
		return "custom404";
	}

}
