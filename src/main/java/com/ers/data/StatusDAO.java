package com.ers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDAO {
	private Connection conn;
	
	public StatusDAO( Connection conn ){
		super();
		this.conn = conn;
	}
}


/*	public void getAll(){
		String sql = "Select REIMB_STATUS_ID from ERS_REIMBURSEMENT_STATUS";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			rs.getInt("REIMB_STATUS_ID");
		} catch (SQLException e){ e.printStackTrace(); }
	}*/