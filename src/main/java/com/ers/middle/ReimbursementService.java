package com.ers.middle;

import java.util.ArrayList;

import com.ers.bean.Reimbursement;
import com.ers.data.DataFacade;
/**
 * Class for reimbursement type services
 * @author bcant
 *
 */
class ReimbursementService {
	
	/**
	 * insert service
	 * @param reimb
	 */
	public void insert( Reimbursement reimb ){
		new DataFacade().insert(reimb);
	}
	
	/**
	 * getAll service
	 * @return
	 */
	public ArrayList<Reimbursement> getAll() {
		return new DataFacade().getAll();
	}
	
	/**
	 * update Service
	 * @param statusId
	 * @param reimbId
	 * @param resolver
	 */
	public void updateStatus( int statusId, int reimbId, int resolver ){
		new DataFacade().updateStatus(statusId, reimbId, resolver);
	}
}
