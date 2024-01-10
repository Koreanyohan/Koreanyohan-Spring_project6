// p.20 
package com.example.demo.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/method")
public class QuizController2 {
	
	@GetMapping("/quiz")
	public ResponseEntity q1() {
		System.out.println("Get방식");
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/q")
	public ResponseEntity q2() {
		System.out.println("Post방식");
		
		return new ResponseEntity(HttpStatus.OK);
	}
	@PutMapping("/q")
	public ResponseEntity q3() {
		System.out.println("Put방식");
		
		return new ResponseEntity(HttpStatus.OK);
	}
	@DeleteMapping("/q")
	public ResponseEntity q4() {
		System.out.println("Delete방식");
		
		return new ResponseEntity(HttpStatus.OK);
	}	
}

