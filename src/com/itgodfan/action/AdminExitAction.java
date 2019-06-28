package com.itgodfan.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:管理员退出登录  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AdminExitAction extends ActionSupport {
	public String exit() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
}
