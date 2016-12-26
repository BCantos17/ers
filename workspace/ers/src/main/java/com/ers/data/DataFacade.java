package com.ers.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

/**
 * Facade for all the DAO's
 * Establish and close connections each time a DAO is called
 * @author bcant
 *
 */
public class DataFacade {
	private Connection conn;
	
	/**
	 * Reimbursement Method
	 * @param reimb
	 */
	public void insert(Reimbursement reimb ){
		ReimbursementDAO dao = null;
		
		/*
		 * Calls insert()
		 */
		try {
			conn = ServiceLocator.getErsDatabase().getConnection();
			conn.setAutoCommit( false );
			dao = new ReimbursementDAO( conn );
			dao.insert( reimb );
			conn.commit();
		}catch ( SQLException e ) {
			try { conn.rollback(); } 
			catch ( SQLException e1 ) { e1.printStackTrace(); }
		}finally{
			try {conn.close();} 
			catch ( SQLException e ) { e.printStackTrace(); }
		}
	}
	
	/**
	 * Reimbursement Method
	 * @return
	 */
	public ArrayList<Reimbursement> getAll(){
		ArrayList<Reimbursement> reimb = null;
		ReimbursementDAO dao = null;
		
		/*
		 * Calls getAll()
		 */
		try {
			conn = ServiceLocator.getErsDatabase().getConnection();
			conn.setAutoCommit( false );
			dao = new ReimbursementDAO( conn );
			reimb = dao.getAll();
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally{
			try { conn.close(); } 
			catch ( SQLException e ) { e.printStackTrace(); }
		}
		
		return reimb;
	}
	
	/**
	 * Reimbursement Method
	 * @param statusId
	 * @param reimbId
	 * @param resolver
	 */
	public void updateStatus(int statusId, int reimbId, int resolver ){
		ReimbursementDAO dao = null;
		
		/*
		 * calls updateStatus()
		 */
		try {
			conn = ServiceLocator.getErsDatabase().getConnection();
			conn.setAutoCommit( false );
			dao = new ReimbursementDAO( conn );
			dao.updateStatus( statusId, reimbId, resolver );
			conn.commit();
		}catch ( SQLException e ) {
			try { conn.rollback(); } 
			catch ( SQLException e1 ) { e1.printStackTrace(); }
		}finally{
			try { conn.close(); } 
			catch ( SQLException e ) { e.printStackTrace(); }
		}
	}
	
	/**
	 * User Method
	 * @param username
	 * @return
	 */
	public User getByUsername( String username ) {
		User user = null;
		UserDAO dao = null;

		/*
		 * calls getByUsername()
		 */
		try {
			conn = ServiceLocator.getErsDatabase().getConnection();
			conn.setAutoCommit( false );
			dao = new UserDAO( conn );
			user = dao.getByUsername( username );
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally{
			try { conn.close(); } 
			catch ( SQLException e ) { e.printStackTrace(); }
		}
		
		return user;
	}
	
	/**
	 * Method to encrypt passwords
	 * Used only once
	 */
/*	public void encryptPassword(){

		try {
			conn = ServiceLocator.getErsDatabase().getConnection();
			conn.setAutoCommit( false );
			new UserDAO( conn ).encryptPassword();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally{
			try { conn.close(); } 
			catch ( SQLException e ) { e.printStackTrace(); }
		}
	}*/
}
