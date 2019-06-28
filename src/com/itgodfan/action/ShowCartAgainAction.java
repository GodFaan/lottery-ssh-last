package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.bean.User;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:  再次添加物品到购物车
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class ShowCartAgainAction extends ActionSupport {
	LotteryCartService lotteryCartService;
	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}
	public String show() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<LotteryCart> list = lotteryCartService.findAll(user.getName());
		for (LotteryCart lotteryCart : list) {
			System.out.println(lotteryCart.getBid());
		}
		if(list.size()>0) {
			ServletActionContext.getRequest().setAttribute("cartlist", list);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
