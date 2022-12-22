package com.moviereview.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.User;
import com.moviereview.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService usrservice;
	
	//get data from sql
	@GetMapping("/users")
	public List<User> getUser(){
		return this.usrservice.getUserData();
	}
	//get user by id
	@RequestMapping(value = "/getuser/{userid}", method = RequestMethod.GET)
	public List<User> getUserData(@PathVariable("userid") Integer userid) {
		return usrservice.getUserData(userid);
	}
	//for login user data
	@GetMapping("/user/{username}/{password}")
	public int UserLogin(@PathVariable("username")String username1,@PathVariable("password") String password1){
		int flag=usrservice.loginValidation(username1, password1);
		if(flag==0) {
			return 0;
		}
		
		return flag ;
	}
	
	//add data into sql
	@PostMapping(value="/adduser")
	public 	boolean addUser(@RequestBody User usr) {
	boolean add=usrservice.addUser(usr);
	return add;	
	}
	
	//delete data
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{username}")
	public void deleteUser(@PathVariable String username)
	{
		usrservice.deleteUser(username);
	}
	//update data
	@PutMapping(value="/updateuser")
	public void updateUser(@RequestBody User usr)
	{
		usrservice.updateUser(usr);
	}
	
}
