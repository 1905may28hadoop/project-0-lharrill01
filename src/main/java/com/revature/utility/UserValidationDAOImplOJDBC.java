package com.revature.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//grabs static members : methods and fields
//import static com.revature.util.ConnectionUtility.*;
//import static java.util.Arrays.*;
// now we have access to Arrays.sort() via sort()

public class UserValidationDAOImplOJDBC implements UserValidationDAO {

	@Override
	public UserValidation getUserValidation(long accountid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserValidation getUserValidation(String username) {
		
		PreparedStatement statement = null;
		ResultSet resultSet =  null;
		UserValidation UserValidation = null;
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			
			//SQL injection:
			//String dangerousInput = username + ";DROP TABLE pet_types;";
			//String sqlStatement = "SELECT * FROM pet_types WHERE username = " + dangerousInput;
			
			statement = conn.prepareStatement("SELECT username FROM USER_ACCOUNT");
			statement.setString(1, username);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next(); // goes to the first result
			UserValidation = new UserValidation(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		return UserValidation;
	}

	public List<UserValidation> getUserValidations() {
		Statement statement = null;
		ResultSet resultSet = null;
		List<UserValidation> UserValidations = new ArrayList<>();
		// We're going to do a try-with-resources
		// this lets us open a resource, like a db connection
		// as a part of starting our try block, and it
		// will be closed automatically when the try
		// block finishes.
		try(Connection conn = ConnectionUtility.getConnection()) {
			//create our statement:
			statement =  conn.createStatement();
			// Statement objects can execute SQL queries
			// THe most basic form of this:
			resultSet = statement.executeQuery("SELECT * FROM USER_ACCOUNT");
			// ResultSet stores all the results from a successful query
			
			// Create ourselves a new UserValidation object for each row:
			while(resultSet.next()) {
				UserValidations.add(new UserValidation(resultSet));
// 					We refactored this out: 
//					resultSet.getLong("id"), // get data by column name
//					resultSet.getString(2),
//					resultSet.getInt("max_energy"),
//					resultSet.getInt(4),
//					null,
//					resultSet.getString(6).equals("T")
//				));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		
		return UserValidations;
	}

	@Override
	public List<UserValidation> getUserValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
