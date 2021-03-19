package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import org.springframework.hateoas.Resource;  

import com.sun.jndi.toolkit.url.Uri;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	static Logger logger = Logger.getLogger(UserController.class.getName());
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return service.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id)
	{
		User user= service.getUser(id);
		if(user==null)
			throw new UserNotFoundException("id-" +id);
		/*
		 * Resource<User> resource=new Resource<User>(user); ControllerLinkBuilder
		 * linkTo=linkTo(methodOn(this.getClass().getUsers()));
		 */
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
	{
		User savedUser=service.addUser(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}") 
	public void deleteById(@PathVariable int id)
	{
		service.deleteById(id);
	}
	
	@GetMapping("/userpages/{name}")
	public Page<User> getUserPages(@PathVariable String name)
	{
		return service.getUserPages(name);
		
	}
	
	
	

}
