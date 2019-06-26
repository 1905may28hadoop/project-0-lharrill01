package com.revature.utility;

import java.util.Scanner;

public class UAuthentication {

	public static void main(String[] args) {
		TransactionQuery transactionQuery = new TransactionQuery();
		
		
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		//as always, define in terms of interface:
		//UserValidationDAO userValidationDAO = new UserValidationDAOImplOJDBC();
		try {
			TransactionQuery.getInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create a UserValidation for testing:
		Scanner userinput = new Scanner(System.in);
		String username, password;
		System.out.println("Enter your Username: ");
		username = userinput.nextLine();
		
		System.out.println("Enter your Password: ");
		password = userinput.nextLine();
		String usernameb = transactionQuery.userName;
		//System.out.println(usernameb);
		String passwordb = transactionQuery.passWord;	
		
		if(username.equals(usernameb) && password.equals(passwordb)) {
			System.out.println("GRANTED");
		}
		else {
			
			System.out.println("Username/Password  is incorrect,try again.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//UserValidation testUserValidation = new UserValidation("username", "password", 01);

		//System.out.println(userValidationDAO.getUserValidation();
		//System.out.println(UserValidationDAO.createUserValidation(testUserValidation));
		//System.out.println(userValidationDAO.getUserValidation("Tiny Bird"));
		//createTableExample();
	}
	
//	private static void createTableExample() {
//		Connection conn = ConnectionUtil.getConnection();
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.executeQuery("CREATE TABLE from_java ( id NUMBER(5) )");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
