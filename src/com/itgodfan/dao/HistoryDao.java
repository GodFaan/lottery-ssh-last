package com.itgodfan.dao;

import java.util.List;

import com.itgodfan.bean.History;

public interface HistoryDao {
public void add(History history);
public void delete(int id);
public History findHistoryById(int id);
public List<History> findAll(String username);
}
