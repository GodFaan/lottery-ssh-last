package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.bean.User;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:展示购彩历史  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class ShowHistoryAction extends ActionSupport {
	LotteryCartService lotteryCartService;
	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}
	public String show() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<LotteryCart> list = lotteryCartService.findAll(user.getName());
		if(list.size()>0) {
			ServletActionContext.getRequest().setAttribute("cartlist", list);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
