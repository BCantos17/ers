package com.ers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.bean.User;

class UserDAO {
	private Connection conn;
	
	public UserDAO( Connection conn ) {
		super();
		this.conn = conn;
	}

	public User getByUsername( String username ) {
		User user = null;
		String sql = "select ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD , USER_FIRSTNAME, "
											+ "USER_LASTNAME, USER_EMAIL, USER_ROLE_ID "
					+ "from ERS_USERS "
					+ "where ERS_USERNAME = ?";
		PreparedStatement stmt = null;
		
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
}