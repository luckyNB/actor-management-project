package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.dto.PersonDTO;
import com.person.response.Response;
import com.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody PersonDTO dto) {

		Response response = service.register(dto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
