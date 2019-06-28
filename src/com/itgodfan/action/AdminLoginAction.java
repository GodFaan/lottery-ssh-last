package com.itgodfan.action;

import com.itgodfan.bean.Admin;
import com.itgodfan.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:管理员登录
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AdminLoginAction extends ActionSupport {
	private AdminService adminService;

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() {
		Admin a=adminService.findUserByName(admin.getName(), admin.getPassword());
		if (a != null) {// 查找是否有对应的人的信息，有就返回成功，跳转到登录成功页面
			ActionContext.getContext().getSession().put("admin", a);
			return SUCCESS;

		} else {// 失败就跳转到登录失败页面
			if(adminService.findUserNameExist(admin.getName())==true) {
				this.addActionError("尊敬的管理员同志，你输入的密码有误，请重新输入！");
				return "passworderror";
			}else {
				this.addActionError("对不起，你输入的管理员账户不存在，请您重新输入！");
				return ERROR;
			}
		}
	}
}
