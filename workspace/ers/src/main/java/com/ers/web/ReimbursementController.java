package com.ers.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.bean.Reimbursement;
import com.ers.bean.RowUpdate;
import com.ers.bean.User;
import com.ers.json.parser.JSONConverter;
import com.ers.middle.BusinessDelegate;

/**
 * Controller for handling update, insert and getAll mehtods
 * @author bcant
 *
 */
class ReimbursementController {
	
	/**
	 * Calls the Business Delegate if the Resolver updated the Reimbursement from Pending to Aprrove or Deny
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User resolver = (User) request.getSession().getAttribute("userData");
		String json = new JSONConverter().getUserJson			( resolver );

		/*
		 * Gets the data AJax sent to the server and converts it from JSON to RowUpdate Object
		 */
		InputStream requestBody = request.getInputStream();
		BufferedReader reader = new BufferedReader( new InputStreamReader( requestBody ) );
		RowUpdate rowList = new JSONConverter().getRowUpdate(reader.readLine());
		
		response.setContentType							( "application/json" );
		response.setCharacterEncoding					( "UTF-8" );
		
		/*
		 * If Resolver updated status to Approve or Deny, update in the database
		 */
		for( Reimbursement temp : rowList.getRowList() )
			if( temp.getStatusId() > 1)
				new BusinessDelegate().updateStatus( temp.getStatusId(), temp.getId(), resolver.getId());

		// Returns the Resolver Object in Json format to client side
		response.getWriter().println( json );
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User author = (User) request.getSession().getAttribute	("userData");
		String json = new JSONConverter().getUserJson			( author );

		/*
		 * Gets the data AJax sent to the server and converts it from JSON to Reimbursement Object
		 */
		InputStream requestBody = 	request.getInputStream();
		BufferedReader reader = 	new BufferedReader(new InputStreamReader(requestBody));
		Reimbursement reimb = new JSONConverter().getReimbursement(reader.readLine());
		
		response.setContentType			( "application/json" );
		response.setCharacterEncoding	( "UTF-8" );
		
		/*
		 * Validates to see if all information pass through are in good condition
		 */
		if( reimb.getAmount() != 0.00 && ( Double ) reimb.getAmount() != null && ( Integer )reimb.getTypeId() != null ) {
			reimb.setAuthor					( author );
			new BusinessDelegate().insert	( reimb );
			response.getWriter().println	( json );
		}
	}
}
