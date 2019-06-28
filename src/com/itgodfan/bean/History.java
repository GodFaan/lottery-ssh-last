package com.itgodfan.bean;

import java.io.Serializable;

public class History implements Serializable{
	private Integer id;//用integer的原因是没值时为null，而使用int的话没值默认为0，相当有值了；
	private String username;
	private String number;
	private String adate;
	private Integer count;
	private Integer sum;
	public History() {
		super();
	}
	public History(Integer id, String username, String number, String adate, Integer count, Integer sum) {
		super();
		this.id = id;
		this.username = username;
		this.number = number;
		this.adate = adate;
		this.count = count;
		this.sum = sum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
}
