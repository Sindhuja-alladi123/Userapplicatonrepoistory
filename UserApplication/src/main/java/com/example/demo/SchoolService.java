package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolService {

	@Autowired
	SchoolRepository repository;
	
	public List<School> getAllSchools() {
		List<School> schools=new ArrayList<School>();
		repository.findAll().forEach(school1->schools.add(school1));	
		return schools;
	}

	public void add(School school) {
		repository.save(school);
		
	}

}
