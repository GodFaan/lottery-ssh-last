package com.itgodfan.bean;

import java.io.Serializable;
import java.util.Date;

public class LotteryCart implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer bid;
	private String number;
	private Integer price;
	private String adate;
	private String username;
	private Integer count;
	private Integer sum;

	public LotteryCart() {
		super();
	}


	public LotteryCart(Integer bid, String number, Integer price, String adate, String username, Integer count,
			Integer sum) {
		super();
		this.bid = bid;
		this.number = number;
		this.price = price;
		this.adate = adate;
		this.username = username;
		this.count = count;
		this.sum = sum;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String string) {
		this.adate = string;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

}
