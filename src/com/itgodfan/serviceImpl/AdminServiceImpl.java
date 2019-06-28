package com.itgodfan.serviceImpl;

import java.util.List;

import com.itgodfan.bean.Admin;
import com.itgodfan.bean.User;
import com.itgodfan.dao.AdminDao;
import com.itgodfan.dao.UserDao;
import com.itgodfan.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;


	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void add(Admin admin) {
		adminDao.add(admin);// 不存在则加入
	}

	@Override
	public void update(Admin admin) {
		if (adminDao.findUserById(admin.getId()) != null) {
			adminDao.update(admin);// 存在才进项改变操作
		}
	}

	@Override
	public void delete(int id) {
		if (adminDao.findUserById(id) != null) {
			System.out.println("change is happennig!");
			adminDao.delete(id);// 存在才进项改变操作
		}
	}

	@Override
	public Admin findUserByName(String name, String password) {

		return adminDao.findUserByName(name, password);
	}

	@Override
	public Admin findUserById(int id) {

		return adminDao.findUserById(id);
	}

	@Override
	public boolean findUserNameExist(String name) {
		
		return adminDao.findUserNameExist(name);
	}

	@Override
	public List<Admin> findAll() {
		
		return adminDao.findAll();
	}

}
