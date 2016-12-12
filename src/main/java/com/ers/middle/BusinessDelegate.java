package com.ers.middle;

import java.util.ArrayList;

import javax.naming.AuthenticationException;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

public class BusinessDelegate {
	
	public User login( String username, String password ) throws AuthenticationException{
		return new UserService().login( username, password );
	}
	
	public void insert( Reimbursement reimb ){
		new ReimbursementService().insert( reimb );
	}
	
	public ArrayList<Reimbursement> getAll(){
		return new ReimbursementService().getAll();
	}
}
