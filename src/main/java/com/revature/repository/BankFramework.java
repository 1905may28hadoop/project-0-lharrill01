package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.utility.ConnectionUtility;

public class BankFramework implements BankStructureBuildable {
	
	Connection conn = null;

	@Override
	public void createAccountPIITable() {
		//Connect to project0 instance
		try {
			conn = ConnectionUtility.getConnection();
			//Create precompiled statement to query database
			String ctablest = "CREATE TABLE ACCOUNTPII(ID INT PRIMARY KEY, USERNAME VARCHAR(20), PASSWORD VARCHAR(20), LASTNAME VARCHAR2(20), FIRSTNAME VARCHAR(20), ADDRESS VARCHAR(255), CITY VARCHAR(255), STATE VARCHAR(255), ZIPCODE NUMBER(5), CONSTRAINT PK_ACCOUNTPII PRIMARY KEY(ID, LASTNAME) FOREIGN KEY(USERNAME) REFERENCES USERACCOUNT(USERNAME))";
			
			PreparedStatement postQuery = conn.prepareStatement(ctablest);
			postQuery.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	 }
		
	}

	@Override
	public void createUserAccountTable() {
		try {
			conn = ConnectionUtility.getConnection();
			//Create precompiled statement to query database
			String ctablest = "CREATE TABLE USERACCOUNT(USERNAME VARCHAR(20) PRIMARY KEY, ACCOUNTID INT, ACCOUNT_TYPE VARCHAR(20), BALANCE NUMBER(*,2), FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNTTRANSACTIONTABLE(ACCOUNTID))";
			
			PreparedStatement postQuery = conn.prepareStatement(ctablest);
			postQuery.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}

	@Override
	public void createAccountTrasnactionTable() {
		try {
			conn = ConnectionUtility.getConnection();
			//Create precompiled statement to query database
			String ctablest = "CREATE TABLE ACCOUNTTRANSACTIONTABLE(ACCOUNTID INT PRIMARY KEY, TRANSACTIONID INT, TRANSACTIONLINEID INT, TRANSACTIONAMOUNT NUMBER(*,2) FOREIGN KEY (TRANSACTIONID) REFERENCES TRANSACTIONTABLE(TRANSACTIONID))";
			
			PreparedStatement postQuery = conn.prepareStatement(ctablest);
			postQuery.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	}

	@Override
	public void createTransactionTable() {
		try {
			conn = ConnectionUtility.getConnection();
			//Create precompiled statement to query database
			String ctablest = "CREATE TABLE TRANSACTIONTABLE(TRANSACTIONID INT PRIMARY KEY, TRANSACTION_TYPE VARCHAR(20))";
			
			PreparedStatement postQuery = conn.prepareStatement(ctablest);
			postQuery.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}

		
}
