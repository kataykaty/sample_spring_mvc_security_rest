package com.sample.spring.app.entity.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private String userName;
	private String fullName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
