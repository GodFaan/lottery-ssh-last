package com.itgodfan.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.User;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:  用户注册
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class UserRegisterAction extends ActionSupport{
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String jieguo() {
		String name=ServletActionContext.getRequest().getParameter("user.name");
		
		boolean result=userService.findUserNameExist(name);//查找数据库，判断用户名是否被注册
		System.out.println(result);
		if(result) {//如果用户名被注册则换个名字
			this.addActionError("该用户名已被注册，请选择新的用户名！");
			return ERROR;
		}else {//名字未被注册，则进行注册操作
			Date adate = new Date();//添加注册日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setStartdate(df.format(adate));
			userService.add(user);
			return SUCCESS;
		}
	}

}
