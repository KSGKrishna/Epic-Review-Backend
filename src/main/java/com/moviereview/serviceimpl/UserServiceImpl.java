package com.moviereview.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereview.DBUtil.DBUtil;
import com.moviereview.model.User;
import com.moviereview.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	static List<User> userlist=new ArrayList<User>();
	 
	Connection connection;
	int flag=0;
	public UserServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}
	
	@Override
	public List<User> getUserData() {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USER_DETAILS");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User usr=new User();
				usr.setUserid(rs.getInt(1));
				usr.setFirstname(rs.getString(2));
				usr.setLastname(rs.getString(3));
				usr.setUsername(rs.getString(4));
				usr.setPassword(rs.getString(5));
//				usr.setConfirm_password(rs.getString(6));
				//usr.setGender(rs.getString(7));
				userlist.add(usr);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return userlist;
	}
//add the data in sql
	@Override
	public boolean addUser(User usr) {
		int userid=usr.getUserid();
		String firstname=usr.getFirstname();
		String lastname=usr.getLastname();
		String username=usr.getUsername();
		String password=usr.getPassword();
//		String confirm_password=usr.getConfirm_password();
		//String gender=usr.getGender();
		
		String insertQuery="INSERT INTO user_details VALUES('"+userid+"','"+firstname+"','"+lastname+"','"+username+"','"+password+"')";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Data Added");
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
	
		}
		return false;
		
	}
//delete user data
	@Override
	public void deleteUser(String name) {
		String deleteQuery="DELETE FROM user_details WHERE username='"+name+"'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("user deleted");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User usr) {
		int userid=usr.getUserid();
		String firstname=usr.getFirstname();
		String lastname=usr.getLastname();
		String username=usr.getUsername();
		String password=usr.getPassword();
//		String confirm_password=usr.getConfirm_password();
		//String gender=usr.getGender();
		
		String updateQuery="UPDATE user_details SET firstname='"+firstname+"',lastname='"+lastname+"',username='"+username+"',password='"+password+"' WHERE userid='"+userid+"';";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("UPDATED SUCCESSFULLY");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
//it is for only login .
	@Override
	public int  loginValidation(String username, String password) {
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT * FROM user_details WHERE username='"+username+"'");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString(2).equals(username)&&rs.getString(5).equals(password)) {
					flag=1;
				}else {
					System.out.println("Invalid username/password");
					flag=0;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
//get user by id
	@Override
	public List<User> getUserData(Integer userid) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USER_DETAILS WHERE userid='"+userid+"'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User usr=new User();
				usr.setUserid(rs.getInt(1));
				usr.setFirstname(rs.getString(2));
				usr.setLastname(rs.getString(3));
				usr.setUsername(rs.getString(4));
				usr.setPassword(rs.getString(5));
//				usr.setConfirm_password(rs.getString(6));
				//usr.setGender(rs.getString(7));
				userlist.add(usr);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userlist;
	}
	

}
