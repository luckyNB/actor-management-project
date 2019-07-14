package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDTO;
import com.student.response.Response;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerStude(@RequestBody StudentDTO dto){
	Response response=service.register(dto);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
}
