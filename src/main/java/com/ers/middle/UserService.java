package com.ers.middle;

import javax.naming.AuthenticationException;

import com.ers.bean.User;
import com.ers.data.DataFacade;

class UserService {

	User login(String username, String password) throws AuthenticationException{
		
		DataFacade dataTier = new DataFacade();
		User user = new User();
		user = dataTier.getByUsername( username );
		if( user == null ) 
			throw new AuthenticationException();
		if( user.getPassword().equals( password ) )
			return user;
		else 
			throw new AuthenticationException();
	}
}
