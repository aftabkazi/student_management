package com.studentmanagement.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.studentmanagement.studentmanagement.entity.Registration;
import com.studentmanagement.studentmanagement.response.GlobalResponse;
import com.studentmanagement.studentmanagement.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/register")
	public GlobalResponse Register(@RequestBody Registration registration) {
		return registrationService.Register(registration);
	}
	@PostMapping("/login")
	public GlobalResponse Login(@RequestBody Registration registration) {
		return registrationService.Login(registration);
	}
}
