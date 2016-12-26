package com.ers.json.parser;

import java.io.IOException;

import com.ers.bean.Reimbursement;
import com.ers.bean.RowUpdate;
import com.ers.bean.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converts String from and to JSON objects
 * @author bcant
 *
 */
public class JSONConverter {
	
	/**
	 *  Converts Reimbursement from object to JSON  String
	 * @param reimb
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String getReimbursementJson( Reimbursement reimb ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().writeValueAsString( reimb );
	}
	
	/**
	 * Converts User from object to JSON String
	 * @param user
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String getUserJson( User user ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().writeValueAsString( user );
	}
	
	/**
	 * Converts Reimbursement from JSON String to object
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Reimbursement getReimbursement( String json ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue(json, Reimbursement.class );
	}
	
	/**
	 * Converts RowUpdate from JSON String to object
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public RowUpdate getRowUpdate( String json ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue(json, RowUpdate.class );
	}
}
