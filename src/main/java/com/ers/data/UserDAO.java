package com.ers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.bean.User;

/**
 * DAO's for getByUsername
 * @author bcant
 *
 */
class UserDAO {
	private Connection conn;
	
	/**
	 * Constructor
	 * @param conn
	 */
	public UserDAO( Connection conn ) {
		super();
		this.conn = conn;
	}

	/**
	 * Execute Query statement to select from User Table
	 * @param username
	 * @return
	 */
	public User getByUsername( String username ) {
		User user = null;
		
		// SQL statement to get relevant information for User object
		String sql = "select ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD , USER_FIRSTNAME, "
											+ "USER_LASTNAME, USER_EMAIL, USER_ROLE_ID "
					+ "from ERS_USERS "
					+ "where ERS_USERNAME = ?";
		PreparedStatement stmt = null;
		
		/*
		 * Sets information into the User object
		 */
		try {
			stmt = conn.prepareStatement( sql );
			stmt.setString( 1, username );
			ResultSet rs = stmt.executeQuery();
			if( rs.next() ){
				user = new User();
				user.setId			( rs.getInt		("ERS_USERS_ID") 	);
				user.setUsername	( rs.getString	("ERS_USERNAME") 	);
				user.setPassword	( rs.getString	("ERS_PASSWORD")	);
				user.setFirstName	( rs.getString	("USER_FIRSTNAME") 	);
				user.setLastName	( rs.getString	("USER_LASTNAME") 	);
				user.setEmail		( rs.getString	("USER_EMAIL") 		);
				user.setRoleId		( rs.getInt		("USER_ROLE_ID") 	);
			} else 
				return null;
		} catch ( SQLException e ) { 
			e.printStackTrace(); }

		return user;
	}
	
	/**
	 * Method to Encrypt Password.
	 * Used only once.
	 */
/*	public void encryptPassword(){
		String sql = "select ERS_PASSWORD "
				+ "from ERS_USERS";
		
		String sqlEncrypt = "update ERS_USERS "
				+ "set ERS_PASSWORD = 	? "
				+ "where ERS_PASSWORD = ?";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ){
				stmt = conn.prepareStatement( sqlEncrypt );
				
				String unhashed = rs.getString("ERS_PASSWORD");
				String hashed = BCrypt.hashpw( rs.getString("ERS_PASSWORD"), BCrypt.gensalt() );
				//System.out.println(hashed);
				
				stmt.setString( 1, hashed 	);
				stmt.setString( 2, unhashed );
				
				stmt.executeQuery();
				
				//System.out.println( BCrypt.checkpw( unhashed, hashed ) );
			}
		} catch ( SQLException e ) { 
			e.printStackTrace(); }
	}*/
}