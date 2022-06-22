package com.studentmanagement.studentmanagement.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentmanagement.studentmanagement.entity.Registration;
import com.studentmanagement.studentmanagement.repository.RegistrationRepository;
import com.studentmanagement.studentmanagement.response.GlobalResponse;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepository;

	public GlobalResponse Register(Registration registration) {
		
		if(registration.getName()==null || registration.getName().isBlank()) {
			return new GlobalResponse(false,"Enter Name");
		}
		else {
			String regex="[a-zA-Z ]*$";
			boolean validName=Pattern.compile(regex).matcher(registration.getName().trim()).matches();
			if(validName==false) {
				return new GlobalResponse(false,"Name is not valid only characters are allowed");
			}
		}
		if(registration.getEmail()==null || registration.getEmail().isBlank()) {
			return new GlobalResponse(false,"Enter Email");
		}
		else {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";  
			boolean validEmail=Pattern.compile(regex).matcher(registration.getEmail().toLowerCase().trim()).matches();
			if(validEmail==false) {
				return new GlobalResponse(false,"Enter valid Email");
			}
		}
		if(registration.getMobile()==null || registration.getMobile().isBlank()) {
			return new GlobalResponse(false,"Enter Mobile number");
		}
		else {
			String regex="(0/91)?[7-9][0-9]{9}";
			boolean validMobile=Pattern.compile(regex).matcher(registration.getMobile().trim()).matches();
			if(validMobile==false) {
				return new GlobalResponse(false,"Enter valid mobile number");
			}
		}
		if(registration.getUsername()==null || registration.getUsername().isBlank()) {
			return new GlobalResponse(false,"Enter Username");
		}
		else {
			String regex="^[A-Za-z]\\w{5,29}$";
			boolean validateUsername=Pattern.compile(regex).matcher(registration.getUsername().trim()).matches();
			if(validateUsername==false)
			{
				return new GlobalResponse(false,"Please Enter valid Username(Username must contain atleast five characters)");
			}
		}
		if(registration.getPassword()==null || registration.getPassword().isBlank()) {
			return new GlobalResponse(false,"Enter Password");
		}
		else{
			String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
			boolean validatePassword=Pattern.compile(regex).matcher(registration.getPassword().trim()).matches();
			   if(validatePassword==false){
				   return new GlobalResponse(false,"password must contain atleast 8 characters,1 upper case,1 lower case ,1 special character and 1 digit");
			   }
		}
		registrationRepository.save(registration);
		return new GlobalResponse(true,"Registration sucessfull");
	}

	public GlobalResponse Login(Registration registration) {
		Registration loginDetails=registrationRepository.findByUsername(registration.getUsername());
		
		if(registration.getUsername()==null || registration.getUsername().isBlank()) {
			return new GlobalResponse(false,"Enter User name");
		}
		else if(registration.getPassword()==null || registration.getPassword().isBlank()) {
			return new GlobalResponse(false,"Enter password");
		}
		else if(loginDetails==null) {
			return new GlobalResponse(false,"User name does not exists");
		}
		else if(loginDetails.getUsername().equals(registration.getUsername())&& (loginDetails.getPassword().equals(registration.getPassword()))) {
			return new GlobalResponse(false,"Login sucessfull");
		}
		return new GlobalResponse(false,"Login failed");
	}

}
