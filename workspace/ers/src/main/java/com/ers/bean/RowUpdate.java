package com.ers.bean;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * A bean specifically made to hold in all the rows meant to be updated at once through Ajax
 */
public class RowUpdate {
	@JsonProperty
	ArrayList<Reimbursement> rowList;

	public RowUpdate() {
		super();
	}

	public RowUpdate(ArrayList<Reimbursement> rowList) {
		this.rowList = rowList;
	}

	public ArrayList<Reimbursement> getRowList() {
		return rowList;
	}

	public void setRowList(ArrayList<Reimbursement> rowList) {
		this.rowList = rowList;
	}
}
