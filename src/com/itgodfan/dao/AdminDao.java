package com.itgodfan.dao;

import java.util.List;

import com.itgodfan.bean.Admin;


public interface AdminDao {
	public void add(Admin admin);
	public void update(Admin admin);
	public void delete(int id);
	public Admin findUserById(int id);
	public boolean findUserNameExist(String name);
	public Admin findUserByName(String name,String password);
	public List<Admin> findAll();
}
