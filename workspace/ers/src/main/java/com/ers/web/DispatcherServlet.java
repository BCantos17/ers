package com.ers.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for calling the proper method on corresponding URI's
 * @author bcant
 *
 */
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	
	/**
	 * Switch condiitions on different URI
	 * If URI does not match, default to 404 error code
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		switch( requestURI ){
			case "/ers/login.do":{
				new UserController().doLogin(request, response);
				break;
			}
			case "/ers/logout.do":{
				new UserController().doLogout(request, response);
				break;
			}
			case "/ers/reimbursement.update.do":{
				new ReimbursementController().doUpdate(request, response);
				break;
			}
			case "/ers/reimbursement.add.do":{
				new ReimbursementController().doInsert(request, response);
				break;
			}
			default:{
				response.setStatus( 404 );
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
