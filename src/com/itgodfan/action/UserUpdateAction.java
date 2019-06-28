package com.itgodfan.action;

import com.itgodfan.bean.User;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:更新用户的相关信息，没用到  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class UserUpdateAction extends ActionSupport {
	private UserService userService;
	private User user;
	private int id;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String showUser() {
		User user = userService.findUserById(id);
		setUser(user);
		return SUCCESS;
	}

	public String update() {
		userService.update(user);
		return SUCCESS;
	}
}
