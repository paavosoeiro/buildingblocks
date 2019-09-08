package com.udemy.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "user")
//@JsonIgnoreProperties({ "firstName", "lastName" })
//@JsonFilter(value = "userFilter")
public class User extends ResourceSupport {

	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long userid;

	@NotEmpty(message = "Username is mandatory. Please provide username")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@JsonView(Views.External.class)
	private String userName;

	@Size(min = 2, message = "FirstName should have at least 2 characters")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String lastName;

	@Column(name = "EMAIL", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	@JsonView(Views.Internal.class)
	private String role;

	@Column(name = "SSN", length = 50, nullable = false, unique = true)
//	@JsonIgnore
	@JsonView(Views.Internal.class)
	private String ssn;

	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;

	public User() {
	}

	public User(String firstName) {
		this.firstName = firstName;
	}

	public User(Long userid, @NotEmpty(message = "Username is mandatory. Please provide username") String userName,
			@Size(min = 2, message = "FirstName should have at least 2 characters") String firstName, String lastName,
			String email, String role, String ssn, List<Order> orders) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
	}

	public User(Long userid, @NotEmpty(message = "Username is mandatory. Please provide username") String userName,
			@Size(min = 2, message = "FirstName should have at least 2 characters") String firstName, String lastName,
			String email, String role, String ssn) {
		this.userid = userid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	public Long getUserId() {
		return userid;
	}

	public void setUserId(Long userId) {
		this.userid = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userid + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}

}
