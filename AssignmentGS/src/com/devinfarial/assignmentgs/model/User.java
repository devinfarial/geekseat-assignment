package com.devinfarial.assignmentgs.model;



public class User {
	private Integer id;
	private String name;

	
	private String email;
	private String password;
	private String role;
	private String status;
	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String password, String role, String status) {

		this(name, email, password, role, status);
		this.id = id;

	}
	
	public User(String name, String email, String password, String role, String status) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	public User(String email, String password) {

		this.email = email;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}
	
	
	

}
