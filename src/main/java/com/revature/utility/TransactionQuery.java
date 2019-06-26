package com.revature.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionQuery {

	static String userName;
	static String passWord;
	
	// Created a main that tells the class Exception that we may have exceptions that we want to catch
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
	
	// Create a metod that returns an arraylist 
	public static ArrayList<String> getInfo() throws Exception{
	try {
		//Calls method getConnection from ConnectionUtility Class
		Connection conn = ConnectionUtility.getConnection();
		
		//Create as statement to query sql database
		PreparedStatement postQuery = conn.prepareStatement("SELECT USERACCOUNT, PASSWORD FROM USER_ACCOUNT");
		ResultSet result = postQuery.executeQuery();
		
		ArrayList<String> array = new ArrayList<String>();
		while (result.next()){
			 userName = result.getString("USERNAME");
			// System.out.println(userName);
			 passWord = result.getString("password");
			
			array.add(result.getString("USERNAME"));
			
		}
		
		//System.out.println("All records have been printed");
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
		
	}

}
