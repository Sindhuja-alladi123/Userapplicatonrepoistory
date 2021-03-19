package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

	@Autowired
	SchoolService service;
	
	@GetMapping("/schools")
	private List<School> getAllSchools(){
		return service.getAllSchools();
	}
	
	@PostMapping("/schools")
	private void addSchool(@RequestBody School school) {
		service.add(school);
	}
	
}
