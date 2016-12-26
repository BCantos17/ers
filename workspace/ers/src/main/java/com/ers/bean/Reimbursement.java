package com.ers.bean;

import java.sql.Blob;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * A Bean for Reimbursement request
 * Contains Id, amount requested, date submitted,
 * date resolved, a description, a receipt (unused in this project),
 * user who submitted, user who resolved the request, the status and the user role.
 * Every variable is a Json property 
 */
public class Reimbursement {
	@JsonProperty
	private int id;
	@JsonProperty
	private double amount;
	@JsonProperty
	private Date submitted;
	@JsonProperty
	private Date resolved;
	@JsonProperty
	private String descript;
	@JsonProperty
	private Blob reciept;
	@JsonProperty
	private User author;
	@JsonProperty
	private User resolver;
	@JsonProperty
	private int statusId;
	@JsonProperty
	private int typeId;
	
	public Reimbursement() {
		super();
	}
	
	/*
	 * Constructor for getting all former reimbursement request
	 */
	public Reimbursement(int id, double amount, Date submitted, Date resolved, String descript, Blob reciept,
			User author, User resolver, int statusId, int typeId) {
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.descript = descript;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	/*
	 * Constructor for adding a new reimbursement request
	 */
	public Reimbursement(double amount, Date submitted, String descript, Blob reciept,
						User author, int statusId, int typeId) {
		this.amount = amount;
		this.submitted = submitted;
		this.descript = descript;
		this.reciept = reciept;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	/*
	 * Getters and setters for all variables
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Blob getReciept() {
		return reciept;
	}
	public void setReciept(Blob reciept) {
		this.reciept = reciept;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}