package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.utility.CloseStreams;
import com.revature.utility.ConnectionUtility;

public class BankTransactions implements BankTransactionable {

	Connection conn = null;
	int id = 1;
	String userName;
	String userName1;
	String passWord;
	String passWord1;
	String firstName;
	String firstName1;
	String lastName;
	String lastName1;
	String address;
	String address1;
	String city;
	String city1;
	String state;
	String state1;
	String zipCode;
	String zipCode1;
	String accountType;
	String depositAmount;
	double depositAmount1;
	String accountType1;

	@Override
	public void addNewAccounts() {
		
		System.out.println("Welcome to Account Registration");
		System.out.println("Lets get started ");
		try {

				// Stopped right here
				
				conn = ConnectionUtility.getConnection();
				Scanner userinput = new Scanner(System.in);
		
				System.out.println("Enter your First Name: ");
				firstName = userinput.nextLine();
				firstName1 = "'"+ firstName + "'";
				System.out.println("Enter your Last Name: ");
				lastName = userinput.nextLine();
				lastName1 = "'"+ lastName + "'";
				System.out.println("Enter a Username: ");
				userName = userinput.nextLine();
				userName1 = "'"+ userName + "'";
				System.out.println("Enter a Password: ");
				passWord = userinput.nextLine();
				passWord1 = "'"+ passWord + "'";
				System.out.println("Enter your Address: ");
				address = userinput.nextLine();
				address1 = "'"+ address + "'";
				System.out.println("Enter your City: ");
				city = userinput.nextLine();
				city1 = "'"+ city + "'";
				System.out.println("Enter your State: ");
				state = userinput.nextLine();
				state1 = "'"+ state + "'";
				System.out.println("Enter your ZipCode: ");
				zipCode = userinput.nextLine();
				zipCode1 = "'"+ zipCode + "'";

				
				System.out.println("What type of account are you opening today");
				System.out.println("Enter Checking, Savings, or Credit Card and press enter.");
				accountType = userinput.nextLine();
				
				System.out.println(" How much will you be depositing today?");
				depositAmount = userinput.nextLine();
				accountType1 = "'"+ accountType + "'";
				depositAmount1 = Double.parseDouble(depositAmount);
				String query = "INSERT INTO ACCOUNTPII VALUES(" + id +","+ firstName1 +","+ lastName1 +"," + userName1 + "," + passWord1 + "," + address1 + "," + city1 + "," + state1 + "," + zipCode +")";
		
				PreparedStatement postQuery = conn.prepareStatement(query);
				postQuery.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				System.out.println("Your information has been updated in the system.");
				System.out.flush();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		PreparedStatement  query= null;
		try(Connection conn = ConnectionUtility.getConnection()){
			query = conn.prepareStatement("UPDATE USERACCOUNT SET BALANCE = ? WHERE ACCOUNT_TYPE = ?");
			query.setDouble(1, depositAmount1);
			query.setString(2,accountType);
			query.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		CloseStreams.close(query);
	}
		
}



	@Override
	public void accountDepositandWithdrawal() {
		System.out.println("Available transactions are: ");
		System.out.println("To make a deposit a type 1 and press enter. ");
		System.out.println("To make a withdrawal type 2  and press enter. ");
		
		// you stopped at creating a switch statement to implememnt deposits and withdrawals
		// take in a value and for withdrawals make the value negative and update the balance
		// after that create a view so that the information can be viewed by the user.
		// once that is done work on creating threads to run the program, setup a state machine.
		

		try {
				double transaction_amount;
		
				conn = ConnectionUtility.getConnection();
				Scanner userinput = new Scanner(System.in);
		

		
			String query = "This is a random statement to satisfy compiler";
		
			PreparedStatement postQuery = conn.prepareStatement(query);
			postQuery.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				System.out.println("Your information has been updated in the system.");
				System.out.flush();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void viewAccountHistory() {
		// TODO Auto-generated method stub
		
	}

}
