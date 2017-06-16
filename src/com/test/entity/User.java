package com.test.entity;

/**
 * User类，对应的数据库Myssh中的表是SysUser
 * User entity. @author MyEclipse Persistence Tools
 */

public class User{

	// Fields
	//类的各个属性，对应于表SysUser各个字段
	private String id;
	private String username;
	private String cname;
	private String password;
	private String mark;
	private String department;
	private String phone;
	// Constructors

	/** default constructor */
	//无参构造函数
	public User() {
	}

	/** minimal constructor */
	//最少参数的构造函数
	public User(String username, String cname,
			String password) {
		
		this.username = username;
		this.cname = cname;
		this.password = password;
		
	}

	/** full constructor */
	//构造函数
	public User(String id, String username, String cname,
			String password, String mark,String department,
	String phone ) {
		this.id = id;
		this.username = username;
		this.cname = cname;
		this.password = password;
		this.mark=mark;
		this.department=department;
		this.phone=phone;
	}

	// Property accessors
	// 各个属性的getter和setter方法
	
	public String getId() {
		return this.id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username
				+ ", cname=" + cname + ", password=" + password
				+ ", mark=" + mark + ",department="+department+",phone="+phone+"]";
	}
	

}