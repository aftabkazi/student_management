package com.studentmanagement.studentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long RegisterId;
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String email;
	private String mobile;
	private String username;
	private String password;
	
	public Registration() {
		super();
	}

	public Registration(Long registerId, String name, String email, String mobile, String username, String password) {
		super();
		RegisterId = registerId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}

	public Long getRegisterId() {
		return RegisterId;
	}

	public void setRegisterId(Long registerId) {
		RegisterId = registerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
}
