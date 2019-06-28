package com.itgodfan.service;

import java.util.List;

import com.itgodfan.bean.Admin;

public interface AdminService {
public void add(Admin admin);
public void update(Admin admin);
public void delete(int id);
public Admin findUserById(int id);
public boolean findUserNameExist(String name);
public List<Admin> findAll();
public Admin findUserByName(String name,String password);
}
