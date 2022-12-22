package com.moviereview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	int userid;
	private	String firstname;
	private   String lastname;
	private   String username;
	private   String password;
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int userid, String firstname, String lastname, String username, String password) {
			super();
			this.userid = userid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
					+ username + ", password=" + password + "]";
		}
	    
	    
	    
}
