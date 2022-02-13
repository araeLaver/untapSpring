package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor	// @NonNull 이나 final이 붙은 인스턴스 변수에 대한 생성자를 만들어 낸다.
//@AllArgsConstructor		// 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성하게 된다.

// 스프링 4.3 이후 단일 생성자의 묵시적 자동 주입
// 스프링의 의존성 주입은 생성자 주입 / Setter 주입
// Setter 주입은 setXXX()와 같은 메서드를 작성하고(혹은 Lombok으로 생성), @Autowired와 같은 어노테이션을 통해서 스프링으로 부터 자신이 필요한 객체를 주입해 주도록 한다.
// 생성자 주입은 이러한 주입을 생성자를 통해서 처리한다. 생성자 주입의 경우 객체 생성 시 의존성 주입이 필요하므로 좀 더 엄격하게 의존성 주입을 체크하는 장점이 있다.
// 기존 스프링에서는 생성자 주입을 하기 위해서 생성자를 정의하고, @Autowired와 같은 어노테이션을 추가해야만 생성자 주입이 이루어 졌지만,
// 스프링 4.3 이후에는 묵시적으로 생성자 주입이 가능하다.

//
//
//

public class SampleHotel
{

	@NonNull
	// 여러 개의 인스턴스 변수들 중에서 특정한 변수에 대해서만 생성자를 작성하고 싶으면 @NonNull, @RequiredArgsConstructor 를 이용한다.
	private Chef chef;

//	private String name;


//	@AllArgsConstructor
//	private Chef chef;


//	@RequiredArgsConstructor, @AllArgsConstructor 없이
//	public SampleHotel(Chef chef)
//	{
//		this.chef = chef;
//	}
}
