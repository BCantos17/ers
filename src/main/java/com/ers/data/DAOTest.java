package com.ers.data;

import java.util.ArrayList;
import java.util.Date;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;

public class DAOTest {
	public static void main(String[] args) {
		
		//testUserDAO();
		//testReimbDAO();
		//encryptUserPass();
		
	}
	
/*	static void encryptUserPass() {
		new DataFacade().encryptPassword();
		
	}*/

	static void testUserDAO(){
		DataFacade facade = new DataFacade();
		User user1 = new User();
		
		user1 = facade.getByUsername	( "jhernandez3" );
		System.out.println( "This username belongs to " + user1.getFullName() );
	}
	
	static void testReimbDAO(){
		DataFacade facade = new DataFacade();
		User user = facade.getByUsername	( "jhernandez3" );
		Reimbursement reimb = new Reimbursement(1000.00, new Date(), "Travel money", null, user, 1, 2);
		facade.insert( reimb );
		ArrayList<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		reimbList = facade.getAll();
		//facade.updateStatus(3, 22, 5);
		for( Reimbursement temp : reimbList ){
			System.out.println( "id" + " " + temp.getId() );
			System.out.println( "amount" + " " + temp.getAmount() );	
			System.out.println( "submitted" + " " + temp.getSubmitted());		
			System.out.println( "description" + " " + temp.getDescript() );	
			System.out.println( "author" + " " + temp.getAuthor().getFullName() );		
			System.out.println( "resolver" + " " + temp.getResolver().getFullName());	
			System.out.println( "statusid" + " " + temp.getStatusId() );	
			System.out.println( "typeid" + " " + temp.getTypeId() );
			System.out.println(" ");
		}
	}
}
