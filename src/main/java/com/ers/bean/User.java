package com.ers.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * A User bean
 * Holds the User id, their username, password, first name, last name, email and their role id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
	@JsonProperty
	int id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonIgnore
	private String email;
	@JsonProperty
	private int roleId;
	
	public User() {
		super();
	}
	
	/*
	 * A complete constructor
	 */
	public User(int id, String username, String password, String firstName, String lastName, String email, int roleId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}
	
	/*
	 * A constructor made for only getting relevant information when getting all Reimbursement Rows
	 * Holds User id, first name, last name and their role id.
	 */
	public User(int id, String firstName, String lastName, int roleId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
	}

	/*
	 * Getters and Setters for all variables
	 * String getFuleName() - returns the first and last name if the User.
	 */
	public String getFullName(){
		return firstName + " " + lastName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}