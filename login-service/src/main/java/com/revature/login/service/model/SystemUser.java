package com.revature.login.service.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;

import org.springframework.stereotype.Component;

//@Entity
//@Table(name="SYSTEM_USERS")
@Component
public class SystemUser {
	//@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_SEQ")
	//@SequenceGenerator(sequenceName="customer_seq", allocationSize=1, name="USER_ID_SEQ")
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	/*
	@OneToOne
	@JoinColumn(name="ROLE_ID")
	public UserRole role;
	*/
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "SystemUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}
}
