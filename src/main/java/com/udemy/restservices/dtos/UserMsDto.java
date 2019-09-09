package com.udemy.restservices.dtos;

public class UserMsDto {

	private Long userId;
	private String userName;
	private String emailaddress;
	private String rolename;

	public UserMsDto() {
		super();
	}

	public UserMsDto(Long userId, String userName, String emailaddress, String rolename) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailaddress = emailaddress;
		this.rolename = rolename;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
