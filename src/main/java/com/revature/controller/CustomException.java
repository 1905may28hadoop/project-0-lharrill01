package com.revature.controller;

public class CustomException extends Exception{
	
	public class InvalidPasswordException extends Exception {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InvalidPasswordException(String errorMessage) {
	        super(errorMessage);
	    }
	}
	public class AccountNotFoundException extends Exception {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AccountNotFoundException(String errorMessage) {
	        super(errorMessage);
	    }
	}

}
