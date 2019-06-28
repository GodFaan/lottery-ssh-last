package com.itgodfan.serviceImpl;

import java.util.List;

import com.itgodfan.bean.User;
import com.itgodfan.dao.UserDao;
import com.itgodfan.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;//本类的一实例对象等于传进的参数
	}

	@Override
	public void add(User user) {
			userDao.add(user);//不存在则加入
	}

	@Override
	public void update(User user) {
		if(userDao.findUserById(user.getId())!=null) {
			userDao.update(user);//存在才进项改变操作
		}
	}

	@Override
	public void delete(int id) {
		if(userDao.findUserById(id)!=null) {
			System.out.println("change is happennig!");
			userDao.delete(id);//存在才进项改变操作
		}
	}

	@Override
	public User findUserByName(String name, String password) {
		
		return  userDao.findUserByName(name, password);
	}

	@Override
	public User findUserById(int id) {
		
		return userDao.findUserById(id);
	}

	@Override
	public List<User> findAll() {
		List<User> list=userDao.findAll();
		System.out.println("service:"+list.size());
		return list;
	}

	@Override
	public boolean findUserNameExist(String name) {
		return userDao.findUserNameExist(name);
	}

	@Override
	public User findUserByOnlyName(String name) {
		
		return userDao.findUserByOnlyName(name);
	}



}
