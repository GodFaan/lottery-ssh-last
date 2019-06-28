package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.Admin;
import com.itgodfan.bean.User;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description: 删除某个用户的操作，只能是权限最高的管理员才可以进行
 * @author GodFan
 * @date 2019年6月8日 @version：
 */
public class UserDeleteAction extends ActionSupport {
	UserService userService = null;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String delete() {
		Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
		int level = admin.getLevel();
		if (level == 0) {// 只有优先级是0级的才可以查看所有管理员的所有信息
			System.out.println("id:"+ServletActionContext.getRequest().getParameter("user.id"));
			int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("user.id"));
			userService.delete(id);
			System.out.println("执行了删除操作");
			List<User> list = userService.findAll();
			ServletActionContext.getRequest().setAttribute("userList", list);// 在可以在jsp上根据userlist属性取得对应的值
			return SUCCESS;
		} else {
			this.addActionError("对不起，您的权限不能进行用户信息删除操作！");
			return ERROR;
		}
	}
}
