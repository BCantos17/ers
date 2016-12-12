package com.ers.middle;

import java.util.ArrayList;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;
import com.ers.data.DataFacade;

class ReimbursementService {
	
	public void insert( Reimbursement reimb ){
		// need to make sure the information is valid
		//DataFacade dataTier = new DataFacade();
		//dataTier.insert( reimb );
	}
	
	public ArrayList<Reimbursement> getAll() {
		return new DataFacade().getAll();
	}
	
	//update mehtod
	
}
