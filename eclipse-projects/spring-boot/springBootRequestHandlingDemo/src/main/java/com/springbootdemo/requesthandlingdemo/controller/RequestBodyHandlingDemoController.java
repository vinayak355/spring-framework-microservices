package com.springbootdemo.requesthandlingdemo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.requesthandlingdemo.model.User;

@RestController
public class RequestBodyHandlingDemoController {
	@PostMapping(path = "/showCredentials")
	public User showCredentials(@RequestBody User user) { // Unmarshalling
		return user; // Marshalling
	}
	
	@PutMapping("/showRequestBody")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, String> showRequestBody(@RequestBody Map<String, String> requestBody) { // Deserializing RequestBody to Map
		return requestBody;
	}
	
	// To read data sent by POST method from a form
	@PostMapping(path = "/showCredentials", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAuthCredentials(@RequestParam String email, @RequestParam String password) {
		return String.format("Email: %s</br>Password: %s", email, password);
	}
	
	@PostMapping(path = "/showAllCredentials", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAllAuthCredentials(@RequestParam MultiValueMap<String, String> paramMap) {
		return String.format("Email: %s</br>Password: %s", paramMap.get("email"), paramMap.get("password"));
	}
}
