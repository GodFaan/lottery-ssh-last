package com.itgodfan.action;

import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:跳转到管理员登录页面  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class BeforeAdminLoginAction extends ActionSupport {
	public String before() {
		return SUCCESS;
	}
}
