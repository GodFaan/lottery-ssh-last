package com.itgodfan.interceptor;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{
	@Override
	// 执行拦截器方法
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 判断session中是否保存了后台的用户的信息
		// 判断是否登录,如果登录,放行,没有登录,跳转到登录页面.
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user != null) {
			// 已经登录过
			System.out.println(user.getName());
			return actionInvocation.invoke();
		} else {
			// 跳转到登录页面:
			System.out.println("meiyouyong pengyou !");
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("您还没有登录!没有权限访问!");
			return ActionSupport.LOGIN;
		}
	}

}
