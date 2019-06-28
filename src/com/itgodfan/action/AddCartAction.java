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
 * @Description:  添加彩票到购物车
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class AddCartAction extends ActionSupport {
	User user;

	public void setUser(User user) {
		this.user = user;
	}

	LotteryCartService lotteryCartService;
	LotteryCart lotteryCart;

	public LotteryCart getLotteryCart() {
		return lotteryCart;
	}

	public void setLotteryCart(LotteryCart lotteryCart) {
		this.lotteryCart = lotteryCart;
	}

	public void setLotteryCartService(LotteryCartService lotteryCartService) {
		this.lotteryCartService = lotteryCartService;
	}

	private String[] pre;
	private String[] aft;

	public String[] getPre() {
		return pre;
	}

	public void setPre(String[] pre) {
		this.pre = pre;
	}

	public String[] getAft() {
		return aft;
	}

	public void setAft(String[] aft) {
		this.aft = aft;
	}

	public String cart() throws Exception {
		if (this.getPre().length == 5 && this.getAft().length == 2) {// 限定前区选号五个，后区选号两个
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < this.getPre().length; i++) {
				sb.append(this.getPre()[i] + " ");
			}
			for (int i = 0; i < this.getAft().length; i++) {
				sb.append(this.getAft()[i] + " ");
			}
			Date adate = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(df.format(adate));
			lotteryCart.setAdate(df.format(adate));
			User user = (User) ActionContext.getContext().getSession().get("user");
			System.out.println(sb.toString());
			lotteryCart.setNumber(sb.toString());
			lotteryCart.setUsername(user.getName());
			int price = 2;
			lotteryCart.setPrice(price);
			int num = 1;
			if (ServletActionContext.getRequest().getParameter("lotteryCart.count") == null
					|| ServletActionContext.getRequest().getParameter("lotteryCart.count") == "") {
				num = 1;
			} else {
				num = Integer.parseInt(ServletActionContext.getRequest().getParameter("lotteryCart.count"));
			}
			lotteryCart.setCount(num);//
			int sum = price * num;
			lotteryCart.setSum(sum);
			// 将彩票加入购物车
			lotteryCartService.add(lotteryCart);
			// 将购物车中信息取出
			List<LotteryCart> list = lotteryCartService.findAll(user.getName());
			ServletActionContext.getRequest().setAttribute("cartlist", list);

			return SUCCESS;
		} else {
			System.out.println("发生错误了");
			return ERROR;
		}

	}

}
