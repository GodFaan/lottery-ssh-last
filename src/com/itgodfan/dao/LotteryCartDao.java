package com.itgodfan.dao;

import java.util.List;

import com.itgodfan.bean.LotteryCart;

public interface LotteryCartDao {
	public void add(LotteryCart lotteryCart);

	public void update(LotteryCart lotteryCart);

	public void delete(int bid);

	public LotteryCart findCartById(int bid);

	public List<LotteryCart> findAll(String username);
}
