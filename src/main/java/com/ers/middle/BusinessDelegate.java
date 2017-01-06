package com.ers.middle;

import java.util.ArrayList;

import javax.naming.AuthenticationException;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

/**
 * Class for delegating method calls to services
 * @author bcant
 *
 */
public class BusinessDelegate {
	
	/**
	 * Delgates login
	 * @param username
	 * @param password
	 * @return
	 * @throws AuthenticationException
	 */
	public User login( String username, String password ) throws AuthenticationException{
		return new UserService().login( username, password );
	}
	
	/**
	 * Delegates insert
	 * @param reimb
	 */
	public void insert( Reimbursement reimb ){
		new ReimbursementService().insert( reimb );
	}
	
	/**
	 * Delegates getAll
	 * @return
	 */
	public ArrayList<Reimbursement> getAll(){
		return new ReimbursementService().getAll();
	}
	
	/**
	 * Delagtes UpdateStatus
	 * @param statusId
	 * @param reimbId
	 * @param resolver
	 */
	public void updateStatus( int statusId, int reimbId, int resolver ){
		new ReimbursementService().updateStatus(statusId, reimbId, resolver);
	}
}
