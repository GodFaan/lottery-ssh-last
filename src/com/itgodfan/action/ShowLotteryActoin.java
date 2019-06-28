package com.itgodfan.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:展示近30期大乐透的开奖结果  
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class ShowLotteryActoin extends ActionSupport {
	private static String url = "http://datachart.500.com/dlt/history/history.shtml";

	public String show() {

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element[][] cp = new Element[100][];
		Elements elements = doc.getElementsByClass("t_tr1");// 找到所有cfont2,或得近30期的编号
		Elements elements1 = doc.getElementsByClass("cfont2");// 找到所有cfont2,或得近30期的前区号码
		Elements elements2 = doc.getElementsByClass("cfont4");// 找到所有cfont4,或得近30期的后区号码
		// ----------------------------------------------------存储开奖日期及期号------------------------------
		String regx1 = "\\d{4}-\\d{2}-\\d{2}";
		String regx2 = "\\d{5}";
		Pattern p2 = Pattern.compile(regx1);
		Pattern p1 = Pattern.compile(regx2);
		Matcher m1 = p1.matcher(elements.toString());
		Matcher m2 = p2.matcher(elements.toString());
		int cishu=0;
		int cishu1=0;
		String qihao[]=new String[60];
		String riqi[]=new String[60];
		int ccc1=0;
		int ccc2=0;
		while (m1.find()) {
			if(cishu%2==0) {
				
				qihao[ccc1]=m1.group().toString();
				ccc1++;
			}
		}
		for(int i=0;i<qihao.length;i++) {
			System.out.println(qihao[i]+"  ");
		}
		while (m2.find()) {
			if(cishu1%2==0) {
				
				riqi[ccc2]=m2.group().toString();
				ccc2++;
			}
		}

		int count = 0;
		List<String> l1 = new ArrayList();
		List<String> l2 = new ArrayList();
		List<String> l3 = new ArrayList();

		for (Element element : elements1) {// 前区
			String s = element.toString().substring(19, 21);
			l2.add(s);

		}
		l2.remove(0);
		for (String o : l2) {
			System.out.print(o + "    ");
		}
		StringBuffer sbb1 = new StringBuffer();
		String[] strr1 = new String[30];
		int ct1 = 0;
		int ji1 = 0;
		for (String c1 : l2) {
			ct1++;
			sbb1.append(c1);
			sbb1.append(" ");
			if (ct1 % 5 == 0) {
				strr1[ji1] = sbb1.toString();
				sbb1.delete(0, strr1.length);
				ji1++;
			}
		}
		for (Element element : elements2) {// 后区
			String s = element.toString().substring(19, 21);
			l3.add(s);
		}

		StringBuffer sbb2 = new StringBuffer();
		String[] strr2 = new String[30];
		int ct2 = 0;
		int ji2 = 0;
		for (String c2 : l3) {
			ct2++;
			sbb2.append(c2);
			sbb2.append(" ");
			if (ct2 % 2 == 0) {
				strr2[ji2] = sbb2.toString();
				sbb2.delete(0, strr2.length);
				ji2++;
			}
		}
		for (int wo = 0; wo < 30; wo++) {
			String ww = "q" + wo;
			ActionContext.getContext().getApplication().put(ww, strr1[wo]);
		}

		for (int wo = 0; wo < 30; wo++) {
			String ww = "h" + wo;
			ActionContext.getContext().getApplication().put(ww, strr2[wo]);
		}
		for (int wo = 0; wo < 30; wo++) {
			String ww = "qi" + wo;
			ActionContext.getContext().getApplication().put(ww, qihao[wo*2]);
		}
		for (int wo = 0; wo < 30; wo++) {
			String ww = "hi" + wo;
			ActionContext.getContext().getApplication().put(ww, riqi[wo*2]);
		}
		return SUCCESS;

	}
}
