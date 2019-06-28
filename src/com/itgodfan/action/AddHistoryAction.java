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
 * @Description:完成支付后添加结果到购物车  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AddHistoryAction extends ActionSupport {
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

	public String add() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("lotteryCart.bid"));
//		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("lotteryCart.bid"));
		lotteryCart = lotteryCartService.findCartById(id);
		history.setAdate(lotteryCart.getAdate());
		history.setNumber(lotteryCart.getNumber());
		history.setUsername(lotteryCart.getUsername());
		history.setCount(lotteryCart.getCount());
		history.setSum(lotteryCart.getSum());
		historyService.add(history);
		lotteryCartService.delete(id);// 购买成功之后就从购物车删除
		List<History> list = historyService.findAll(lotteryCart.getUsername());
		ServletActionContext.getRequest().setAttribute("historylist", list);
		return SUCCESS;
	}
}
