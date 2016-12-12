package com.ers.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

public class DataFacade {
	private Connection conn;
	
	/**
	 * Reimbursement methods 
	 * @param reimb
	 */
	public void insert(Reimbursement reimb ){
		ReimbursementDAO dao = null;
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
	
	public ArrayList<Reimbursement> getAll(){
		ArrayList<Reimbursement> reimb = null;
		ReimbursementDAO dao = null;
		
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
	
	public void updateStatus(int statusId, int reimbId, int resolver ){
		ReimbursementDAO dao = null;
		
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
	public User getByUsername( String username ) {
		User user = null;
		UserDAO dao = null;

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
}
