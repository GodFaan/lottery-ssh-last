package com.itgodfan.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:  用户退出登录
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class UserExitAction extends ActionSupport {
	public String exit() {
		Map session=ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
}
