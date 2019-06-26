package com.revature.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserValidation {
	
	private String username;
	private long password;
	private long userID;
	double balance;
	
	public UserValidation() {
		
		super();
		this.userID = userID;
		this.username = username;
		this.balance = balance;
		this.password = password;
		
		
	}
	public UserValidation(ResultSet resultSet) throws SQLException{
		this(resultSet.getLong("userID"), resultSet.getString("username") , resultSet.getDouble("balance"), resultSet.getLong("password"));
	
	}
	public UserValidation(long long1, String string, double double1, long long2) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public long getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(long password) {
		this.password = password;
	}
	/**
	 * @return the accountid
	 */
	public long getUserID() {
		return userID;
	}
	/**
	 * @param accountid the accountid to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "UserValidation[ username = " + username + ", password = " +password + "User ID = " + userID + " Account Balance* " + balance + "]";
	}
	
	

}
