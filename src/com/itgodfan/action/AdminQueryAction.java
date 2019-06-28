package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.Admin;
import com.itgodfan.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:按照优先级查找管理员的账户信息  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AdminQueryAction extends ActionSupport {
private AdminService adminService;
public AdminService getAdminService() {
	return adminService;
}
public void setAdminService(AdminService adminService) {
	this.adminService = adminService;
}

public String query() {
	Admin admin=(Admin) ActionContext.getContext().getSession().get("admin");
	int level=admin.getLevel();
	if(level==0) {//只有优先级是0级的才可以查看所有管理员的所有信息
		List<Admin> list=adminService.findAll();
		ServletActionContext.getRequest().setAttribute("adminList", list);
		return SUCCESS;
	}else {
		this.addActionError("对不起，您的管理权限过低，无权查看所有管理员信息");
		return ERROR;
	}
}
}
