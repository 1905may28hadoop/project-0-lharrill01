package com.revature.controller;

import com.revature.utility.ConnectionUtility;
import com.revature.utility.TransactionQuery;
import com.revature.utility.UAuthentication;
import com.revature.utility.UserValidation;
import com.revature.utility.UserValidationDAO;
import com.revature.utility.UserValidationDAOImplOJDBC;

public interface BankController {

	public static void main(String[] args) throws Exception {
		

		UserValidationDAO userValidationDAO= new UserValidationDAOImplOJDBC();
		
		UserValidation testUserValidation = new UserValidation(resultSet.getLong(3L), resultSet.getString("ftank36") , resultSet.getDouble(200.00D), resultSet.getLong(1234L));
		
			}
		
	}
