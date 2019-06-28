package com.itgodfan.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:跳转到用户登录成功界面  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class JumpToUserPageAction extends ActionSupport {
	public String jump() {
		return SUCCESS;
	}
}
