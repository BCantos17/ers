package com.ers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

/**
 * DAOs for insert, getAll, and updateStatus
 * @author bcant
 *
 */
class ReimbursementDAO {
	private Connection conn;
	 
	/**
	 * Constructor
	 * @param conn
	 */
	public ReimbursementDAO( Connection conn ){
		super();
		this.conn = conn;
	}
	
	/**
	 * Executes insert query to Reimbursement table
	 * @param reimb
	 */
	public void insert( Reimbursement reimb ){
		Date date = new Date();
		// SQL Query for insert
		String sql = 	"insert into ERS_REIMBURSEMENT("
							+ "REIMB_AMOUNT, REIMB_SUMBITTED, REIMB_DESCRIPTION, "
							+ "REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID ) "
						+"values( ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		
		/*
		 * Sets variables into SQL statement
		 */
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble		( 1, reimb.getAmount() 						);
			stmt.setTimestamp	( 2, new java.sql.Timestamp(date.getTime())	);
			stmt.setString		( 3, reimb.getDescript()					);
			stmt.setBlob		( 4, reimb.getReciept()						);
			stmt.setInt			( 5, reimb.getAuthor().getId()	 			);
			stmt.setInt			( 6, 1 										);
			stmt.setInt			( 7, reimb.getTypeId() 						);
			stmt.executeUpdate()								 			;
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	/**
	 * Executes select query for Reimbursement table and
	 * left joins on User table for the Author and Resolver.
	 * @return
	 */
	public ArrayList<Reimbursement> getAll(){
		ArrayList<Reimbursement> reimbList = null;
		
		/*
		 * Query statement to select the reimbursement rows and 
		 * uses left joins to get both the author's and resolvers's columns
		 */
		String sql = "select REIMB_ID, REIMB_AMOUNT, REIMB_SUMBITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, "
								+ "REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID, "
				
		/*Author's info*/	+ "AUTHOR.ERS_USERS_ID, AUTHOR.USER_FIRSTNAME, "
								+ "AUTHOR.USER_LASTNAME, AUTHOR.USER_ROLE_ID, "
		
		/*Resolver's Info*/	+ "RESOLVER.ERS_USERS_ID as RESOLVER_ID, RESOLVER.USER_FIRSTNAME as RESOLVER_FIRSTNAME, "
								+ "RESOLVER.USER_LASTNAME as RESOLVER_LASTNAME, RESOLVER.USER_ROLE_ID as RESOLVER_ROLE_ID "
								
					+ "from ERS_REIMBURSEMENT "
					+ "left outer join ERS_USERS AUTHOR "
					+ "on REIMB_AUTHOR = AUTHOR.ERS_USERS_ID "
					+ "left outer join ERS_USERS RESOLVER "
					+ "on REIMB_RESOLVER = RESOLVER.ERS_USERS_ID "
					+ "order by REIMB_ID";
		
		PreparedStatement stmt;

		/*
		 * Inserts Author's, Resolver's and Reimbursement information into
		 * their respective objects
		 */
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			reimbList = new ArrayList<Reimbursement>();
			while( rs.next() ){
				
				// Creates new User object and sets the author's information into the object
				User author = new User( 	rs.getInt	("ERS_USERS_ID")	,
											rs.getString("USER_FIRSTNAME")	,
											rs.getString("USER_LASTNAME")	, 	
											rs.getInt	("USER_ROLE_ID") 	);

				// Creates new User object and sets the resolver's information into the object
				User resolver = new User(	rs.getInt	("RESOLVER_ID")			,
											rs.getString("RESOLVER_FIRSTNAME")	,
											rs.getString("RESOLVER_LASTNAME")	, 	
											rs.getInt	("RESOLVER_ROLE_ID")	);
				
				// Creates new Reimbursement object and set the column of the row into the object
				Reimbursement newReimb = new Reimbursement(
										rs.getInt	( "REIMB_ID" )			, 
										rs.getDouble( "REIMB_AMOUNT" )		, 
										rs.getDate	( "REIMB_SUMBITTED" )	, 
										rs.getDate	( "REIMB_RESOLVED" )	, 
										rs.getString( "REIMB_DESCRIPTION" )	, 
										rs.getBlob	( "REIMB_RECEIPT" )		, 
										author								, 
										resolver							, 
										rs.getInt	( "REIMB_STATUS_ID" )	, 
										rs.getInt	( "REIMB_TYPE_ID" )		);
				
				// Add to reimbursement row to an Array List
				reimbList.add			( newReimb );
				
			}
		} catch (SQLException e){ e.printStackTrace(); }
		return reimbList;
	}
	
	/**
	 * Execute update query on StatusId
	 * @param statusId
	 * @param reimbId
	 * @param resolver
	 */
	public void updateStatus( int statusId, int reimbId, int resolver ){
		Date date = new Date();
		
		// Query statement for updating the status
		String sql = "update ERS_REIMBURSEMENT "
					+ "set REIMB_RESOLVED = ?, "
					+ "REIMB_RESOLVER = 	?, "
					+ "REIMB_STATUS_ID = 	? "
					+ "where REIMB_ID = 	?";
		PreparedStatement stmt;
		
		/*
		 * Updates the Reimbursement table in the database
		 */
		try {
			stmt = conn.prepareStatement( sql );	
			stmt.setTimestamp	( 1, new java.sql.Timestamp( date.getTime() )	);
			stmt.setInt			( 2, resolver									);
			stmt.setInt			( 3, statusId 									);
			stmt.setInt			( 4, reimbId	 								);
			stmt.executeUpdate();
		} catch ( SQLException e ){ e.printStackTrace(); }
	}
	
}