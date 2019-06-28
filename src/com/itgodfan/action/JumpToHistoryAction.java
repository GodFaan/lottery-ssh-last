package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.History;
import com.itgodfan.bean.User;
import com.itgodfan.service.HistoryService;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:跳转到查看历史记录页面  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class JumpToHistoryAction extends ActionSupport {
	LotteryCartService lotteryCartService;
	History history;
	public void setHistory(History history) {
		this.history = history;
	}
	HistoryService historyService;
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}
	public String jump() {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<History> list = historyService.findAll(user.getName());
		if(list.size()>0) {
			
			ServletActionContext.getRequest().setAttribute("historylist", list);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
