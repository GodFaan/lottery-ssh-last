package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.History;
import com.itgodfan.bean.LotteryCart;
import com.itgodfan.bean.User;
import com.itgodfan.service.HistoryService;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:删除某个历史记录  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class DeleteHistoryAction extends ActionSupport{
	HistoryService historyService;

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public void setLotteryCart(LotteryCart lotteryCart) {
		this.lotteryCart = lotteryCart;
	}

	History history;
	LotteryCart lotteryCart;
	LotteryCartService lotteryCartService;
	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}

	public String delete() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("history.id"));
		System.out.println("id=:"+id);
		lotteryCart = lotteryCartService.findCartById(id);
		historyService.delete(id);// 删除
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<History> list = historyService.findAll(user.getName());
		if(list==null) {
			return ERROR;
		}else {
			ServletActionContext.getRequest().setAttribute("historylist", list);
			return SUCCESS;
		}
	}
}
