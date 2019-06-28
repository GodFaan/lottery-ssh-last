package com.itgodfan.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @Description:跳转到用户登录页面  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class BeforeUserLoginAction extends ActionSupport {
	public String before() {
		return SUCCESS;
	}
}
