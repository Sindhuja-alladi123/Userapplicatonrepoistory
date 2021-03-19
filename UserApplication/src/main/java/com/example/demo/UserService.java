package com.example.demo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	@Autowired
	UserRepository repository;
	

	private static List<User> users=new ArrayList<>();
	
	static
	{
		users.add(new User(1, "abc",new Date()));
		users.add(new User(2, "xyz",new Date()));
		users.add(new User(3, "mno",new Date()));
		users.add(new User(4, "pqr",new Date()));
		users.add(new User(5, "klm",new Date()));
				
	}
	
	public List<User> getUsers()
	{	
		List<User> users = new ArrayList<User>();  
		repo.findAll().forEach(user -> users.add(user));  
		return users;  
	}
	
	public User getUser(int id)
	{
		return repository.findById(id).get();
		
	
	}
	
	public User addUser(User user)
	{
		return repo.save(user);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}

	public Page<User> getUserPages(String name) {
		
		Pageable pagewithtwousers=PageRequest.of(0, 2);
		return repo.findAllByName(name,pagewithtwousers);
	}
	/*public ResponseList getAllAssetsPginate(String assettype, int pageno, int pagesize) throws Exception {
        PageRequest paging = PageRequest.of(pageno, pagesize);
        Page<User> page = repo.findUsers(assettype, paging);
        int totalPages = page.getTotalPages();
        System.out.println(totalPages);
        long totalElements = page.getTotalElements();
        System.out.println(totalElements);
        List<User> list = page.getContent();
        if(list != null) {
        ResponseList response = new ResponseList();
        response.setNoOfrecords(totalElements);
        response.setTotalNumberOfPages(totalPages);
        response.setList(list);   
        return response;
        }else {
            throw new Exception("No Data present In Assect");
        }
       
    }*/

}
