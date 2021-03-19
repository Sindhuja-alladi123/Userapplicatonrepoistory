package com.example.demo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Integer>{
	
	
	Page<User> findAllByName(String name,Pageable pagewithtwousers);

}
