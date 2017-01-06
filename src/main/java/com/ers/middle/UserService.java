package com.ers.middle;

import javax.naming.AuthenticationException;

import org.mindrot.jbcrypt.BCrypt;

import com.ers.bean.User;
import com.ers.data.DataFacade;

/**
 * Class for user type services
 * @author bcant
 *
 */
class UserService {
	
	/**
	 * Method for seeing if the User put the correct Username
	 * @param username
	 * @param password
	 * @return
	 * @throws AuthenticationException
	 */
	User login(String username, String password) throws AuthenticationException{
		DataFacade dataTier = new DataFacade();
		User user = new User();
		
		// Calls the DataFacde
		user = dataTier.getByUsername( username );

		if( user == null ) 
			throw new AuthenticationException();
		if( BCrypt.checkpw( password, user.getPassword() ) )
			return user;
		else 
			throw new AuthenticationException();
	}
}
