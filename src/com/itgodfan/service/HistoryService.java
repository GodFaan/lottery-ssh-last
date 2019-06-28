package com.itgodfan.service;

import java.util.List;

import com.itgodfan.bean.History;

public interface HistoryService {
		public void add(History history);
		public void delete(int id);
		public List<History> findAll(String username);
}
