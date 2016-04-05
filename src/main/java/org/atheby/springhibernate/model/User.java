package org.atheby.springhibernate.model;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String firstname;
	
	public User() {};
	
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
