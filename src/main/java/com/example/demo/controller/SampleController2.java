// p.19 Mapping 어노테이션
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller 지정
@RequestMapping("/method") // 중간 경로값 설정
public class SampleController2 {

	@GetMapping("/ex") // -> 주소 : get방식 + /method/ex
	public ResponseEntity ex1() {
		System.out.println("get메서드 - 요청..");

		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/ex") // -> 주소 : Post방식 + /method/ex
	public ResponseEntity ex2() {
		System.out.println("post메서드 - 등록..");

		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/ex") // -> 주소 : Put방식 + /method/ex
	public ResponseEntity ex3() {
		System.out.println("put메서드 - 수정..");

		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/ex") // -> 주소 : Delete방식 + /method/ex
	public ResponseEntity ex4() {
		System.out.println("delete메서드 - 삭제..");

		return new ResponseEntity(HttpStatus.OK);
	}
		
}