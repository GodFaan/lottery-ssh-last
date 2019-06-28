package com.itgodfan.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:  仅仅是为了实现页面的跳转操作而已，跳转到用户注册界面
 * @author GodFan
 * @date 2019年6月2日  
 * @version：
 */
public class JumpToRegisterAction extends ActionSupport {
	public String jump() {
		return SUCCESS;
	}
}
