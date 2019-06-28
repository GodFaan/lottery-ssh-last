package com.itgodfan.serviceImpl;

import java.util.List;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.dao.LotteryCartDao;
import com.itgodfan.service.LotteryCartService;

public class LotteryCartServiceImpl implements LotteryCartService {
	private LotteryCartDao lotteryCartDao;

	public void setLotteryCartDao(LotteryCartDao lotteryCartDao) {
		this.lotteryCartDao = lotteryCartDao;
	}

	@Override
	public void add(LotteryCart lotteryCart) {
		lotteryCartDao.add(lotteryCart);
	}

	@Override
	public void update(LotteryCart lotteryCart) {
		lotteryCartDao.update(lotteryCart);
	}

	@Override
	public void delete(int bid) {
		if (lotteryCartDao.findCartById(bid) != null) {
			lotteryCartDao.delete(bid);
		}
	}

	@Override
	public List<LotteryCart> findAll(String username) {
		List<LotteryCart> list = lotteryCartDao.findAll(username);
		return list;
	}

	@Override
	public LotteryCart findCartById(int bid) {
		return lotteryCartDao.findCartById(bid);
	}

}
