package com.itgodfan.service;

import java.util.List;

import com.itgodfan.bean.User;

public interface UserService {
public void add(User user);
public void update(User user);
public void delete(int id);
public User findUserByName(String name,String password);
public User findUserByOnlyName(String name);
public User findUserById(int id);
public boolean findUserNameExist(String name);
public List<User> findAll(); 
}
