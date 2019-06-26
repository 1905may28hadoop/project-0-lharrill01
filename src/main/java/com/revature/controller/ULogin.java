package com.revature.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ULogin {

	
	private int userid;
	private String useraccount;
	private double balance;
	private int password;
	
	
	public ULogin(int userid, String useraccount, double balance, int password) {
		super();
		this.userid = userid;
		this.useraccount = useraccount;
		this.balance = balance;
		this.password = password;
	}
	public ULogin(ResultSet rS) throws SQLException {
		this(rS.getInt("userid"),
				rS.getString("useraccount"),
				rS.getDouble("balance"),
				rS.getInt("password"));
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the useraccount
	 */
	public String getUseraccount() {
		return useraccount;
	}
	/**
	 * @param useraccount the useraccount to set
	 */
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(int password) {
		this.password = password;
	}
	public static char[] getUseraccount(Object username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
