// p.22 파라미터 종류 
 
package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BookDTO;

@Controller // controller 지정
@RequestMapping("/param") // 중간 경로값 설정
public class SampleController3 {
	
// 1. @RequestParam
	
	@GetMapping("/ex1")
	public ResponseEntity ex1(@RequestParam(name="i") int i) {// int형 값 하나를 파라미터로 받음
		System.out.println("int형 파라미터 수집 : " + i);
		
		return new ResponseEntity(HttpStatus.OK);
		
		// 호출 => localhost:8080/param/ex1?i=100   -> 100이 매개변수로 드감
	}
	
	@GetMapping("/ex2")
	public ResponseEntity ex2(@RequestParam(name="i") int i, @RequestParam(name="c") char c) {
																// int형, char 값을 파라미터로 받음
		System.out.println("int형 파라미터 수집 : " + i + " char형 파라미터 수집 : " + c);
		
		return new ResponseEntity(HttpStatus.OK);
		
		// 호출 => localhost:8080/param/ex2?i=100&c=야   -> 100이 매개변수로 드감
	}	
	
	
	@GetMapping("/ex3")
	public ResponseEntity ex3(@RequestParam(name="arr") int[] arr) { //arr 이라는 이름의 파라미터가 여러개 전달되더라도 배열로 수집됨.
		// 배열 -> 문자열로 변환					매개변수로 받은 배열을 받음
		System.out.println("int형 배열 수집 " + Arrays.toString(arr)); 
											// 매개변수로 받은 배열을 문자로 변환
		
		return new ResponseEntity(HttpStatus.OK);
		
		// 호출 => localhost:8080/param/ex3?arr=1&arr=2&arr=3   -> 이런식으로 배열에 드갈 값 넣어서 매개변수로 드감
	}	
	
	@GetMapping("/ex4")
	public ResponseEntity ex4(@RequestParam(name="list") ArrayList<Integer> list) { //list 라는 이름의 파라미터가 여러개 전달되더라도 list로 수집됨.
														// 매개변수로 받은 리스트를 받음
		System.out.println("Integer형 리스트 수집 : " + list); 
											
		
		return new ResponseEntity(HttpStatus.OK);
		
		// 호출 => localhost:8080/param/ex4?list=1&list=2&list=3   -> 이런식으로 리스트에 드갈 값 넣어서 매개변수로 드감
	}
	
	@GetMapping("/ex5")
//	public ResponseEntity ex5(@RequestParam(name="date") @DateTimeFormat(pattern="yyyy/MM/dd") LocalDate date) {
//	public ResponseEntity ex5(@RequestParam(name="date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
	public ResponseEntity ex5(@RequestParam(name="date") @DateTimeFormat(pattern="yyyyMMdd") LocalDate date) {
																		// 날짜 입력될 패턴
		System.out.println("날짜 수집 : " + date); 

		
		return new ResponseEntity(HttpStatus.OK);
		
		// 호출 => localhost:8080/param/ex5?date=2024/01/10
		// 호출 => localhost:8080/param/ex5?date=2024-01-10
		// 호출 => localhost:8080/param/ex5?date=20240110
	}	
	
	
	
// 2. @RequestParam
	
	@GetMapping("/ex6/{i}")
	public ResponseEntity ex6(@PathVariable(name="i") int i) {
		System.out.println("int형 파라미터 수집" + i);
		
		return new ResponseEntity(HttpStatus.OK);

		// 호출 => localhost:8080/param/ex6/100
	}	
	
	
	
// 3. @RequestBody 	
	// 브라우저에서 호출 못함. PostMan사용. RequestBody에 의해 json데이터가 서버통해클래스로 변환됨.
	
	@GetMapping("/ex7")
	public ResponseEntity ex7 (@RequestBody BookDTO dto){
		System.out.println("객체 수집" + dto);
		
		return new ResponseEntity(HttpStatus.OK);
		// 호출 => localhost:8080/param/ex7+json
	}
	
	
	@GetMapping("/ex8")
	public ResponseEntity ex8 (@RequestBody ArrayList<BookDTO> list){
		System.out.println("객체타입 리스트 수집" + list);
		
		return new ResponseEntity(HttpStatus.OK);
		// 호출 => localhost:8080/param/ex8+json
	}
	
	
}











