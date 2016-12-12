package com.ers.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.bean.Reimbursement;
import com.ers.middle.BusinessDelegate;

class ReimbursementController {

	public void doAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Reimbursement> reimb = new BusinessDelegate().getAll();
		request.getSession().setAttribute("reimbData", reimb);
		
	}
	
}
