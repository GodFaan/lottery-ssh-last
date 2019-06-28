package com.itgodfan.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itgodfan.bean.LotteryCart;
import com.itgodfan.bean.User;
import com.itgodfan.service.LotteryCartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:从历史记录中追号，再次添加到购物车  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AddCartAgainAction extends ActionSupport {
	User user;
	LotteryCartService lotteryCartService;
	LotteryCart lotteryCart;
	public void setUser(User user) {
		this.user = user;
	}
	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}
	public void setLotteryCart(LotteryCart lotteryCart) {
		this.lotteryCart = lotteryCart;
	}
	public String cart() {
		System.out.println("ke yihui xian ke ");
		Date adate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		lotteryCart.setAdate(df.format(adate));
		User user = (User) ActionContext.getContext().getSession().get("user");
		lotteryCart.setNumber(ServletActionContext.getRequest().getParameter("history.number"));
		lotteryCart.setUsername(user.getName());
		int price = 2;
		lotteryCart.setPrice(price);
		int num = 1;
		lotteryCart.setCount(num);
		int sum = price * num;
		lotteryCart.setSum(sum);
		lotteryCartService.add(lotteryCart);
		List<LotteryCart> list = lotteryCartService.findAll(user.getName());
		ServletActionContext.getRequest().setAttribute("cartlist", list);//回显到购物车页面
		System.out.println("ke yihui xian ke ");
		return SUCCESS;
	}
}
