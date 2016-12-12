package com.ers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDAO {
	private Connection conn;
	
	public TypeDAO( Connection conn ){
		super();
		this.conn = conn;
	}
}

/*	
	public String getType( int id ){
		String sql = "Select REIMB_TYPE_ID "
				+ "from ERS_REIMBURSEMENT_TYPE "
				+ "where REIMB_Type_ID = ?";
		PreparedStatement stmt;
		int typeId = 0;
		
		try {
			stmt = conn.prepareStatement( sql );	
			ResultSet rs = stmt.executeQuery();
			rs.next();
			typeId = rs.getInt("REIMB_TYPE_ID");
		} catch (SQLException e){ e.printStackTrace(); }
		
		return typeId;
	}*/