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
public class SampleHotel
{

	@NonNull
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
