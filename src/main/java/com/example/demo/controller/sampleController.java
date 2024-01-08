/*6장 p.9*/
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller // 컨트롤러로 지정
@RequestMapping("/return_") // 중간 경로
public class sampleController {
	
	
	@GetMapping({"/ex1"}) /* get방식, 끝주소 ex1 */
	public void ex1() { 
		/* return_폴더 밑의 ex1파일반환하겠다. /return_/ex1이라 */
	    /* ㄴ template/return_/ex1.html */		
	}
	
	@GetMapping("/ex2")
	public String ex2() {
		return "/return_/ex1.html"; // html경로를 지정
	}
	
	@ResponseBody
	@GetMapping("/ex3")	
	public BookDTO ex3() {
		
		BookDTO bookDto
		= new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000);
		
		return bookDto;		
	}	
	
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4 (){
		List<BookDTO> list = new ArrayList<>();
		
		list.add(new BookDTO("자바책1", "동아출판1", 10000));
		list.add(new BookDTO("자바책2", "동아출판2", 20000));
		list.add(new BookDTO("자바책3", "동아출판3", 30000));
		
		return list;
			
	}	
		
	@GetMapping("/ex5")
	public ResponseEntity ex5(){		
		
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
		
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6(){		
		
		return new ResponseEntity<>("sucess... : ", HttpStatus.OK);
								// ( 메시지 		  , 응답코드)
		
	}
	
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7(){		
		
		BookDTO bookDto = new BookDTO("자바입문", "동아출판", 15000);
		
		// 200 ok 응답 + Book 객체
		return new ResponseEntity<>(bookDto, HttpStatus.OK); 				
	}
	
	
}