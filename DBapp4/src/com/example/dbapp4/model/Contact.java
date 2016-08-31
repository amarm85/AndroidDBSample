package com.example.dbapp4.model;

public class Contact extends Model{

	private String name;
	private String phone;
	private String email;
	private String create_at;
	
	public Contact(){}
	
	public Contact(String name, String phone, String email, String create_at) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.create_at = create_at;
	}
	
	public Contact(int id,String name, String phone, String email, String create_at) {
		super(id);
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.create_at = create_at;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	
	
}
