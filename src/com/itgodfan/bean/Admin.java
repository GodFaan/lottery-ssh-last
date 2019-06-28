package com.itgodfan.bean;

import java.io.Serializable;

public class Admin implements Serializable {
	private Integer id;// 防止为缺省默认0值
	private String name;
	private String password;
	private String startdate;
	private Integer level;

	public Admin() {
		super();
	}

	public Admin(Integer id, String name, String password, String startdate, Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.startdate = startdate;
		this.level = level;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
