package com.itgodfan.dao;

import java.util.List;

import com.itgodfan.bean.User;

public interface UserDao {
public void add(User user);
public void update(User user);
public void delete(int id);
public User findUserByName(String name,String password);
public User findUserByOnlyName(String name);
public boolean findUserNameExist(String name);
public User findUserById(int id);
public List<User> findAll();
}
