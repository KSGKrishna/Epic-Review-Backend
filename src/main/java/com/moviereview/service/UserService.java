package com.moviereview.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moviereview.model.User;

@Repository
public interface UserService {
 
	//get the data from sql
	public List <User> getUserData();
	//get user by id
	public List <User> getUserData(Integer userid);
	//add data to sql
	public 	boolean addUser(User usr);
	//delete the data
	public void deleteUser(String username);
	//update the data
	public void updateUser(User usr);
	
	public int loginValidation(String username,String password);
	
}
