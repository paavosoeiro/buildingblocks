package com.udemy.restservices.dtos;

import java.util.List;

import com.udemy.restservices.entities.Order;

public class UserDtoV2 {
	
	private Long userid;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String ssn;
	private List<Order> orders;
	private String address;

	public UserDtoV2() {
		super();
	}

	public UserDtoV2(Long userid, String userName, String firstName, String lastName, String email, String role,
			String ssn, List<Order> orders, String address) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
