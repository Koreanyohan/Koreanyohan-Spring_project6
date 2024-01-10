 // p.25-26 quiz 
package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;


@Controller
@RequestMapping("/param")
public class QuizController3 {
	
	//Q.1
	@GetMapping("/q1")
	public ResponseEntity q1(@RequestParam(name="str") String str) {
		System.out.println("String타입 파라미터 수집 : " + str);
		
		return new ResponseEntity(HttpStatus.OK);
		// http://localhost:8080/param/q1?str=hello
	}
	
	//Q.2
	@GetMapping("/q2")
	public ResponseEntity q2(@RequestParam(name="fl") float fl, @RequestParam(name="bl") boolean bl) {
		System.out.println("float타입 파라미터 수집 : " + fl + "boolean타입 파라미터 수집: " + bl);
		
		return new ResponseEntity(HttpStatus.OK);
		// http://localhost:8080/param/q2?fl=1.55&bl=true
	}
	
	//Q.3
		@ResponseBody
		@GetMapping("/q3")
		public ResponseEntity q3(@RequestParam(name="arr") char[] arr) {
			System.out.println("char형 배열수집 : " + Arrays.toString(arr));
			for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
			}
			
			System.out.println("배열의 개수" + arr.length);			
			
			return new ResponseEntity(HttpStatus.OK);
			// http://localhost:8080/param/q3?arr=a&arr=b&arr=c
		}
	
	//Q4
		@PostMapping("/q4")
		public ResponseEntity q4(@RequestBody StudentDTO stuDTO ) {
			System.out.println("객체 수집 : " + stuDTO);						
									
			return new ResponseEntity(HttpStatus.OK);
			// http://localhost:8080/param/q4 + json작성
		}	
		
	//Q5
		@PostMapping("/q5")
		public ResponseEntity q5(@RequestBody ArrayList<StudentDTO> list ) {
			System.out.println("객체타입 리스트 수집 : " + list);						
					
			for (int i = 0 ; i<list.size() ; i++) {
				System.out.println(list.get(i));
			}
			/*for (StudentDTO dto : list) {
				System.out.println(dto);
			}*/
			
			System.out.println("리스트의 개수: " + list.size());
			
			return new ResponseEntity(HttpStatus.OK);
			// http://localhost:8080/param/q5 + json작성
		}	
		
	//Q6
	
		@PostMapping("/q6")
		public ResponseEntity q6(@RequestBody ArrayList<CarDTO> list ) {
			System.out.println("객체타입 리스트 수집 : " + list);						
					
			for (int i = 0 ; i<list.size() ; i++) {
				System.out.println(list.get(i));
			}			
			/*
			 * for(CarDTO dto : list) { System.out.println(dto); }
			 */
			
			System.out.println("리스트의 마지막 요소" + list.get(list.size()-1));
			
			return new ResponseEntity(HttpStatus.OK);
			// http://localhost:8080/param/q5 + json작성
		}				
	
		
	
	
}

