package com.itgodfan.action;

import java.util.Map;

import com.itgodfan.bean.User;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:普通用户登录  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class UserLoginAction extends ActionSupport {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		User u = userService.findUserByName(user.getName(), user.getPassword());
		if (u != null) {//查找是否有对应的人的信息，有就返回成功，跳转到登录成功页面
			ActionContext.getContext().getSession().put("user", u);
			return SUCCESS;

		} else {//失败就跳转到登录失败页面
			if(userService.findUserNameExist(user.getName())==true) {
				this.addActionError("尊敬的会员，对不起，您输入的密码有误，请您重新输入！");
				return "passworderror";
			}else {
				this.addActionError("对不起，您输入的账户不存在，请您检查是否有输入错误！");
				return ERROR;
			}
		}
	}
	public String logout() {
		 Map session = ActionContext.getContext().getSession();
	        try {
	            session.remove("user");
	            System.out.println("退出成功！");
	            return SUCCESS;
	        } catch (Exception e) {
	            return INPUT;
	        }
	}
}
