package com.itgodfan.serviceImpl;

import java.util.List;

import com.itgodfan.bean.History;
import com.itgodfan.dao.HistoryDao;
import com.itgodfan.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
	private HistoryDao historyDao;


	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	@Override
	public void add(History history) {
		
		historyDao.add(history);
	}

	@Override
	public void delete(int id) {
		
		if (historyDao.findHistoryById(id) != null) {
			historyDao.delete(id);
		}
	}
	@Override
	public List<History> findAll(String username) {
		List<History> list=historyDao.findAll(username);
		return list;
	}

}
