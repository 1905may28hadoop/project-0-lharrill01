package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.utility.CloseStreams;
import com.revature.utility.ConnectionUtility;

public class BController implements BankStates{

	private static final Object username = null;
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rS = null;
	ULogin ulogin = null;
	String useraccount = null;
	
	
	
	public void userlogin() {
		// TODO Auto-generated method stub
		
		try {
			conn = ConnectionUtility.getConnection();

			
			Scanner userinput = new Scanner( System.in);
			System.out.println("Welcome to the Extremely Small Bank of Reston");
			System.out.println("Enter your Username: ");
			String useraccount = userinput.nextLine();
			System.out.println("Enter your 4 digit pin");
			
			String password1 = userinput.nextLine();
			
			stmt = conn.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USERID = ? AND PASSWORD = ?");
			stmt.setString(1 , useraccount);
			stmt.setInt(2, password1);
			stmt.setDouble(3, accountbalance);
			stmt.execute();
			rS = stmt.getResultSet();
//			try {
				rS.next();
			ulogin = new ULogin(rS);
		/*		
			ULogin ULogin = new ULogin(rS.getInt("userid"),
				rS.getString("useraccount"),
				rS.getDouble("balance"),
				rS.getInt("password"));
				*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("here");
		}


		finally {
		CloseStreams.close(rS);
		CloseStreams.close(stmt);
	}
		
	}

	@Override
	public void userView() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println(ULogin.getUseraccount(useraccount));
		System.out.println("\n");
		System.out.println("A. Total Balance");
		System.out.println("B. Make a Deposit");
		System.out.println("C. Make a Withdraw");
		System.out.println("D. Exit");
		
		do {
			System.out.println("========= Revature ============");
			System.out.println("Enter a number for command");
			System.out.println("========= Revature ============");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			case 'A':
				System.out.println("========= Revature ============");
				System.out.println("Balance = $" + accountbalance );
				System.out.println("========= Revature ============");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("========= Revature ============");
				System.out.println("Waiting on Deposit:");
				System.out.println("========= Revature ============");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("========= Revature ============");
				System.out.println("Waiting on Withdraw:");
				System.out.println("========= Revature ============");
				int amount1 = scanner.nextInt();
				withdraw(amount1); 
				System.out.println("\n");
				break;
				
			default:
				System.out.println("========= Revature ============");
				System.out.println("NOT A MONEY TRANCATION");
				System.out.println("========= Revature ============");
			}
		}while( option != 'D');
		System.out.println("========= Revature ============");
		System.out.println("Thank You. Trancation Menu Closed");
		System.out.println("========= Revature ============");

//		
		
	}

	static int accountbalance;

	public int getULogin2(int password) {
			
			PreparedStatement stmt = null;
			ResultSet rS =  null;
			ULogin ULogins = null;
			
			System.out.println("test");
			
			try(Connection conn = ConnectionUtility.getConnection()) {
				System.out.println("test 1");	
				//SQL injection:
				//String dangerousInput = typename + ";DROP TABLE pet_types;";
				//String sqlstmt = "SELECT * FROM pet_types WHERE typename = " + dangerousInput;
				System.out.println("test 2 ");
				stmt = conn.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE password = ?");
				stmt.setInt(1,password);
				stmt.execute();
				rS = stmt.getResultSet();
				
				System.out.println("test 3");
				rS.next(); // goes to the first result
				System.out.println("test 4");
				ULogins = new ULogin( rS.getInt("USERID"),
						rS.getString("USERACCOUNT"),
						rS.getDouble("BALANCE"),
						rS.getInt("PASSWORD"));
				System.out.println("test");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				CloseStreams.close(stmt);
				CloseStreams.close(rS);
			}
			System.out.println(accountbalance);
			return (int) accountbalance;
		}

	@Override
	public void userlogout() {
		// TODO Auto-generated method stub
		
	}
		
	

//SERVICE
	// Calls the database updating Balance column
	public static void withdraw(int amount) {
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Withdraw");
//		long acNum = 101;

		// GET BALANCE OF ACCOUNT
//		accountDAO accountDAO = new accountDAOImplOJDBC();
//		double balance = accountDAO.getAccount(acNum).getBalance();
//		System.out.println("Balance: " + balance);
//		
//		System.out.println("How much would you like to withdraw: ");
//		double withdraw = scan.nextDouble();
//		
		accountbalance -= amount;
		
		// UPDATE ACCOUNT
//		Account updateBal = new Account(acNum, balance);
//		accountDAO.updateAccount(updateBal);
		
		// GET NEW BALANCE
		System.out.println("New Balance: " + accountbalance);
		
		// Gives the user to choose again
//		transactionloop(baseId, acNum);
	}
	
	// SERVICE
	// Calls the database updating Balance column
	public static void deposit(int amount1) {

//		Scanner scan = new Scanner(System.in);
//		System.out.println("Deposit");
//		long acNum = 101;

		// GET BALANCE OF ACCOUNT
//		accountDAO accountDAO = new accountDAOImplOJDBC();
//		double balance = accountDAO.getAccount(acNum).getBalance();
//		System.out.println("Balance: " + balance);
		
//		System.out.println("How much would you like to deposit: ");
//		double deposit = scan.nextDouble();
		
		accountbalance += amount1;
		
		// UPDATE ACCOUNT
//		Account updateBal = new Account(acNum, balance);
//		accountDAO.updateAccount(updateBal);
		
		// GET NEW BALANCE
		System.out.println("New Balance: " + accountbalance);
		
		// Gives the user to choose again 
//		transactionloop(baseId, acNum);
	}

	@Override
	public void userlogin(String useraccount, int password) {
		// TODO Auto-generated method stub
		
	}
	
}

