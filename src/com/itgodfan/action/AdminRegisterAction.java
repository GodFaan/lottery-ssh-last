package com.itgodfan.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.Admin;
import com.itgodfan.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:管理员注册  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AdminRegisterAction extends ActionSupport {
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}

	private AdminService adminService;

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String jieguo() {
		String name = ServletActionContext.getRequest().getParameter("admin.name");
		System.out.println(name);
		boolean result = adminService.findUserNameExist(name);// 查找数据库，判断用户名是否被注册
		System.out.println(result);
		if (result) {// 如果用户名被注册则换个名字
			this.addActionError("该管理员账户已存在，请选择新的用户名！");
			return ERROR;
		} else {// 名字未被注册，则进行注册操作
			Date adate = new Date();// 添加注册日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			admin.setStartdate(df.format(adate));
			admin.setLevel(1);
			adminService.add(admin);
			return SUCCESS;
		}
	}
}
