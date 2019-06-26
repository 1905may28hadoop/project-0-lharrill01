package com.revature.controller;

public class BControllerLast implements BankStateLast {

	@Override
	public void bTrans() {
		// SERVICE
		// Calls the database updating Balance column
		public static void withdraw(long baseId, long acNum) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Withdraw");
//			long acNum = 101;

			// GET BALANCE OF ACCOUNT
			accountDAO accountDAO = new accountDAOImplOJDBC();
			double balance = accountDAO.getAccount(acNum).getBalance();
			System.out.println("Balance: " + balance);
			
			System.out.println("How much would you like to withdraw: ");
			double withdraw = scan.nextDouble();
			
			balance -= withdraw;
			
			// UPDATE ACCOUNT
			Account updateBal = new Account(acNum, balance);
			accountDAO.updateAccount(updateBal);
			
			// GET NEW BALANCE
			System.out.println("New Balance: " + balance);
			
			// Gives the user to choose again
			transactionloop(baseId, acNum);
		}
		
		// SERVICE
		// Calls the database updating Balance column
		public static void deposit(long baseId, long acNum) {

			Scanner scan = new Scanner(System.in);
			System.out.println("Deposit");
//			long acNum = 101;

			// GET BALANCE OF ACCOUNT
			accountDAO accountDAO = new accountDAOImplOJDBC();
			double balance = accountDAO.getAccount(acNum).getBalance();
			System.out.println("Balance: " + balance);
			
			System.out.println("How much would you like to deposit: ");
			double deposit = scan.nextDouble();
			
			balance += deposit;
			
			// UPDATE ACCOUNT
			Account updateBal = new Account(acNum, balance);
			accountDAO.updateAccount(updateBal);
			
			// GET NEW BALANCE
			System.out.println("New Balance: " + balance);
			
			// Gives the user to choose again 
			transactionloop(baseId, acNum);
		}
		
	}

		
		System.out.println("Transaction");
	}

	@Override
	public void baccountView() {
		// TODO Auto-generated method stub

		System.out.println("Bank View");
	}

	@Override
	public void accountLogin() {
		// TODO Auto-generated method stub

		System.out.println("Account Login");
	}

}
