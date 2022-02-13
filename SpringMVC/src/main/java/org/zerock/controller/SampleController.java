package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
// 현재 클래스의 모든 메서드들의 기본적인 URL 경로가 된다.
@Log4j
public class SampleController
{

	// 날짜 데이터 변수
	// @InitBinder
	// binding(바인딩) 파라미더를 변환해서 처리


	//	public void initBinder(WebDataBinder binder)
	//	{
	//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	//	}

	@RequestMapping("")
	public void basic()
	{

		log.info("basic...................");

	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	// GET, POST 방식 모두를 지원해야 하는 경우에 배열로 처리해서 지정 가능하다.
	// 스프링 4.3버전 부터는 @RequestMapping을 줄여서 사용할 수 있는 @GetMapping, @PostMapping으로 축약형 표현 사용 가능
	public void basicGet()
	{
		log.info("basic get...................");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2()
	{
		log.info("basic get only get...................");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto)
	{
		log.info("" + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age)
						// @RequestParam은 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우에 사용
	{
		log.info("name: " + name);
		log.info("age: " + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	// LIST
	public String ex02List(@RequestParam("ids") ArrayList<String> ids)
	{
		log.info("ids: " + ids);

		return "ex02List";
	}

	@GetMapping("/ex02Array")
	// ARRAY 배
	public String ex02Array(@RequestParam("ids") String[] ids)
	{
		log.info("array ids: " + Arrays.toString(ids));

		return "ex02Array";
	}

	@GetMapping("/ex02Bean")
	// [Index] 형태
	// JavaScript에는 encodeURIComponent()와 같은 방법으로 해결 가능
	public String ex02Bean(SampleDTOList list)
	{
		log.info("list dtos: " + list);
		// '[' -> '%5B'
		// '[' -> '%5D'
		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo)
	{
		log.info("todo: " + todo);
		return "ex03";
	}

	// 데이터 전달 방식
	// Servlet에서 모델2방식으로 전달
	// request.setAttribute("serverTime", new java.util.Date());
	// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	// dispatcher.forward(request, response);
	//
	//	스프링 MVC에서 Model 전달
	//	public String home(Model model)
	//	{
	//		model.addAttribute("serverTime", new java.util.Date());
	//		return "home";
	//	}



	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page)
	// @ModelAttribute 어노테이션
	// Request에 전달된 데이터를 가지고 필요하다면 추가적인 데이터를 생성해서 화면으로 전달하는 방식으로 동작
	// Model의 경우는 파라미터로 전달된 데이터는 존재하지 않지만 화면에서 필요한 데이터를 전달하기 위해 사용
	// 예를 들어 페이지 번호는 파라미터로 전달되지만, 결과 데이터를 전달하려면 Model에 담아서 전달
	//
	// 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할때 필요한 어노테이션이다.
	// @ModelAttribute가 걸린 파라미터는 타입에 관계없이 무조건 Model에 담아서 전달되므로, 파라미터로 전달된 데이터를 다시 화면에서
	// 사용해야 할 경우 유용하게 사용
	//
	//
	{
		log.info("dto: " + dto);
		log.info("page: " + page);

		return "/sample/ex04";
	}

	// Model 타입과 더불어서 스프링 MVC가 자동으로 전달해 주는 타입 중에는 RedirectAttributes 타입이 존재
	// 일회성으로 데이터를 전달하는 용도로 사용
	//
	//
	//
	// RedirectAttributes
	//  - Servlet에서 redirect 방식
	//  response.sendRedirect("/home?name=aaa&age=10");
	//
	// 스프링 MVC에서 redirect 방식
	// rttr.addFlashAttribute("name", "AAA");
	// rttr.addFlashAttribute("age", 10);
	// return "redirect:/";



	// Controller의 리턴 타입
	// String : jsp를 이용하는 경우에는 jsp 파일의 경로와 파일 이름을 나타내기 위해서 사용
	//  - 키워드 추가 가능
	//  - redirect : 리다이렉트 방식으로 처리하는 경우
	//  - forward : 포워드 방식으로 처리하는 경우
	// void : 호출하는 URL과 동일한 이름의 jsp를 의미
	// [객체 타입]VO(Value Object), DTO(Data Transfer Object) : 주로 JSON 타입의 데이터를 만들어서 반환하는 용도로 사용
	//  - 복합적인 데이터가 들어간 객체 타입으로 지정할 수 있는데, 이 경우는 주로 JSON 데이터를 만들어 내는 용도로 사용한다.
	//  - jackson-databind 라이브러리 추가 해야됨
	//  -
	// ResponseEntity : response 할 때 Http 헤더 정보와 내용을 가공하는 용도로 사용
	// Model, ModelAndView : Model로 데이터를 반환하거나 화면까지 같이 지정하는 경우에 사용
	// HttpHeaders : 응답에 내용 없이  Http 헤더 메시지만 전달하는 용도로 사용


	@GetMapping("/ex05")
	// void - 동일한 이름 jsp 사용
	public void ex05()
	{
		log.info("/ex05..........");
	}

	@GetMapping("/ex06")
	// 객체 타입 반환
	public @ResponseBody SampleDTO ex06()
	{
		log.info("/ex06..........");

		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");

		return dto;
	}

	@GetMapping("/ex07")
	// ResponseEntity 타입
	// MVC의 사상은 HttpServletRequest나 HttpServletResponse를 직접 핸들링하지 않아도 작업이 가능하다
	// ResponseEntity를 통해 원하는 헤더 정보나 데이터를 전달 할 수 있다.
	// HttpHeaders 객체를 같이 전달할 수 있고, 이를 통해서 원하는 HTTP 헤더 메시지를 가공하는 것이 가능하다.

	//
	//
	public ResponseEntity<String> ex07()
	{
		log.info("/ex07..........");

		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		log.info(msg);
		log.info(header);
		log.info(log);
		log.info(getClass());
		log.info("@@@@@!!!!!");

		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}

	@GetMapping("/exUpload")
	// Servlet 3.0 전까지는 commons의 파일 업로드를 이용하거나 cos.jar 등을 이용해서 처리 해왔다.
	// Servlet 3.0 이후(Tomcat 7.0)에는 기본적으로 업로드되는 파일을 처리할 수 있는 기능이 추가 되었다.
	// Legacy Project로 생성되는 프로젝트의 경우 Servlet 2.5를 기준으로 생성되기 때문에 3.0 이후에 지원되는 설정을 사용하기 어렵다.
	// commons-fileupload를 이용하도록 한다.
	//
	//
	public void exUpload()
	{
		log.info("/exUpload..........");
	}

	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files)
	{
		files.forEach(file -> {
			log.info("----------------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());

		});
	}

}
