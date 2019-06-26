package com.revature.utility;

import java.util.List;

public interface UserValidationDAO {
	// there are a few standard names for these types of methods
	// get, find to get/find things from the DB
	// create to add new
	// save, update to add new ones/update
	// delete or remove
	
	// get PetType by id:
	UserValidation getUserValidation(long accountid);
	
	UserValidation getUserValidation(String username);
	
	List<UserValidation> getUserValidation();

	List<UserValidation> getUserValidations();

}
