package com.itgodfan.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.History;
import com.itgodfan.bean.User;
import com.itgodfan.service.HistoryService;
import com.itgodfan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:根据用户名查找用户信息，并将结果回显到相应页面  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class SearchForUserAction extends ActionSupport {
	private UserService userService;
	private HistoryService historyService;
	private History history;

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;

	public String query() {
		User u = userService.findUserByOnlyName(user.getName());
		if (u != null) {
			List<History> list = historyService.findAll(u.getName());
			ServletActionContext.getContext().put("id", u.getId().toString());
			ServletActionContext.getContext().put("name", u.getName());
			ServletActionContext.getContext().put("password", u.getPassword());
			ServletActionContext.getContext().put("gender", u.getGender());
			ServletActionContext.getContext().put("email", u.getEmail());
			ServletActionContext.getContext().put("telephone", u.getTelephone());
			ServletActionContext.getContext().put("introduce", u.getIntroduce());
			ServletActionContext.getContext().put("startdate", u.getStartdate());
			if(list.size()==0) {
				this.addActionError("对不起，查找客户暂时没有购物信息！");
				return NONE;
			}else {
				ServletActionContext.getRequest().setAttribute("historylist", list);
				return SUCCESS;
			}
		} else {
			this.addActionError("对不起，您输入的客户账户不存在！");
			return ERROR;
		}
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

}
