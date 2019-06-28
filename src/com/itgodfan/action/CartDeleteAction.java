package com.itgodfan.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.bean.User;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:从购物车中删除某个彩票  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class CartDeleteAction extends ActionSupport {
LotteryCartService lotteryCartService;

public void setLotteryCartService(LotteryCartService lotteryCartService) {
	this.lotteryCartService = lotteryCartService;
}
public String delete() {
	int bid=Integer.parseInt(ServletActionContext.getRequest().getParameter("lotteryCart.bid"));
	//执行删除操作
	lotteryCartService.delete(bid);
	//再次获取数据库中的信息
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
