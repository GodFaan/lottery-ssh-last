package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.User;
import com.itgodfan.service.AdminService;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:查看所有注册用户的信息，这一操作只有所有的管理员有权限  
 * @author GodFan
 * @date 2019年6月8日  
 * @version：
 */
public class UserQueryAction extends ActionSupport {
	private UserService userService;
	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String query() {
		List<User> list = userService.findAll();
		ServletActionContext.getRequest().setAttribute("userList", list);// 在可以在jsp上根据userlist属性取得对应的值
		return SUCCESS;
	}
}
