
  package com.moviereview.EpicReviews.controller;
  
  import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviereview.DBUtil.DBUtil;
import com.moviereview.model.User;
import com.moviereview.service.UserService;
import com.moviereview.serviceimpl.UserServiceImpl;
//import com.mysql.cj.MysqlConnection;
  
  	@RunWith(SpringRunner.class)
  
  	@SpringBootTest 
  	class UserControllerTest<userlist> {
  
  
  
  private static final String username = "mani";

@Autowired 
  	private UserService userService;
  
  @MockBean 
  	private UserServiceImpl userServiceImpl;

//private String username;
  
  
  @Test 
  	public void getUserTest() { 
	  
	  when(userService.getUserData()).thenReturn((List<User>)Stream.of 
			  (new User(1,"mani","sankar","mani123","123456")).collect(Collectors.toList()));
  
	  assertEquals(1, userService.getUserData().size());
  
  
  }
  

  
//   @CsvSource({
//	   "1st-userid,2nd-userid"
//   })
  @Test
  public void getUserByIdTest(){ 
	   Integer userid=12;
             when( userServiceImpl.getUserData(12)).thenReturn(( Stream.of 
  				(new User(12,"mani","sankar","mani","123456")).collect(Collectors.toList()))); 
		assertNotEquals(1, userServiceImpl.getUserData(userid)); }
  
//  
//  
//  @Test 
//  public void addUserTest() { 
//	  Connection connection  = DBUtil.getConnection();;
////	  User user=new User(12,"mani","sankar","mani","123456");
//	  String insertQuery="INSERT INTO user_details VALUES(12,mani,sankar,mani,123456)";
//	  PreparedStatement stmt = connection.prepareStatement(insertQuery);
//		stmt.executeUpdate();
//  		when(userService.addUser(username)).thenReturn((insertQuery)); 
//  		assertEquals(12, userServiceImpl.addUser(insertQuery)); }
  
  
  



@Test 
@Query
  	public void deleteUserTest() throws SQLException {
	Connection connection  = DBUtil.getConnection();;

	String deleteQuery="DELETE FROM user_details WHERE username='"+username+"'";
	PreparedStatement stmt = connection.prepareStatement(deleteQuery);
	stmt.executeUpdate();
  		userServiceImpl.deleteUser(toString("mani"));
  		verify(userService,times(1)).deleteUser(username); }



private String toString(String username) {
	// TODO Auto-generated method stub
	return username;
}
  
  }
 