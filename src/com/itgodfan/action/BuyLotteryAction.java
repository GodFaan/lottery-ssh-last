package com.itgodfan.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:爬取网页数据，  将推荐的号码显示在购彩页面
 * @author： GodFan
 * @date： 2019年6月10日  
 */
public class BuyLotteryAction extends ActionSupport {
	private static String url = "http://datachart.500.com/dlt/history/history.shtml";

	public String buy() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String gaoo = "";
		String dii = "";
		String jii = "";

		Element[][] cp = new Element[100][];
		Elements elements = doc.getElementsByClass("t_tr1");// 找到所有cfont2,或得近30期的编号
		Elements elements1 = doc.getElementsByClass("cfont2");// 找到所有cfont2,或得近30期的前区号码
		Elements elements2 = doc.getElementsByClass("cfont4");// 找到所有cfont4,或得近30期的后区号码
		int count = 0;
		for (Element element : elements) {
			String s = element.toString();

			int len = s.length();
		}
		Map<Integer, Integer> map = new HashMap();
		for (Element element : elements1) {
			count++;
			if (count > 1) {
				String s = element.toString().substring(19, 21);
				int shu = 0;
				for (int i = 0; i < s.length(); i++) {
					shu = shu * 10 + s.charAt(i) - '0';
				}
				if (map.containsKey(shu)) {
					map.put(shu, map.get(shu) + 1);
				} else {
					map.put(shu, 1);
				}
			}
		}
		for (int i = 1; i < 36; i++) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			// 升序排序
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
//		System.out.println("后区：");
		int num = 1;
		Map<Integer, Integer> map1 = new HashMap();
		for (Element element : elements2) {
			if (num <= 60) {
				String s = element.toString().substring(19, 21);
//				System.out.println(s);
				int shu = 0;
				for (int i = 0; i < s.length(); i++) {
					shu = shu * 10 + s.charAt(i) - '0';
				}
//				System.out.println(shu);
				if (map1.containsKey(shu)) {
					map1.put(shu, map1.get(shu) + 1);
				} else {
					map1.put(shu, 1);
				}
			}
			num++;
		}
		for (int i = 1; i < 13; i++) {
			if (map1.containsKey(i)) {
				map1.put(i, map1.get(i) + 1);
			} else {
				map1.put(i, 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list1 = new ArrayList<Map.Entry<Integer, Integer>>(map1.entrySet());
		Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer>>() {
			// 升序排序
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		// 输出最多最少值
		System.out.println("为您推荐的号码（近30期高频号码）是：");
		int cc = 0;
		Iterator it = list.iterator();
		Set se1 = new TreeSet();
		while (it.hasNext()) {
			if (cc < 5) {
				se1.add(((Entry<Integer, Integer>) it.next()).getKey());
				cc++;
			} else {
				it.next();
				cc++;
			}
		}
		Iterator itt = se1.iterator();
		int ji1 = 0;
		while (itt.hasNext()) {
			String temp = itt.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				gaoo = gaoo + "0" + temp + " ";
			} else {

				gaoo = gaoo + temp + " ";
			}
			ji1++;
		}
		int cd = 0;
		Iterator it1 = list1.iterator();
		Set se2 = new TreeSet();
		while (it1.hasNext()) {
			if (cd < 2) {
				se2.add(((Entry<Integer, Integer>) it1.next()).getKey());
				cd++;
			} else {
				it1.next();
				cd++;
			}
		}
		Iterator itt1 = se2.iterator();
		while (itt1.hasNext()) {
			String temp = itt1.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				gaoo = gaoo + "0" + temp + " ";
			} else {

				gaoo = gaoo + temp + " ";
			}
			ji1++;
		}
		List<Map.Entry<Integer, Integer>> list11 = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list11, new Comparator<Map.Entry<Integer, Integer>>() {
			// 升序排序
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		System.out.println("为您推荐的号码（近30期低频号码）是：");
		int cc1 = 0;
		Iterator it11 = list11.iterator();
		Set se3 = new TreeSet();
		while (it11.hasNext()) {
			if (cc1 < 5) {
				se3.add(((Entry<Integer, Integer>) it11.next()).getKey());
			} else {
				it11.next();
			}
			cc1++;

		}
		int ji2 = 0;
		Iterator itt2 = se3.iterator();
		while (itt2.hasNext()) {
			String temp = itt2.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				dii = dii + "0" + temp + " ";
			} else {

				dii = dii + temp + " ";
			}
			ji2++;

		}
		List<Map.Entry<Integer, Integer>> list12 = new ArrayList<Map.Entry<Integer, Integer>>(map1.entrySet());
		Collections.sort(list12, new Comparator<Map.Entry<Integer, Integer>>() {
			// 升序排序
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		int cd1 = 0;
		Iterator it12 = list12.iterator();
		Set se4 = new TreeSet();
		while (it12.hasNext()) {
			if (cd1 < 2) {
				se4.add(((Entry<Integer, Integer>) it12.next()).getKey());
			} else {
				it12.next();
			}
			cd1++;

		}
		Iterator itt3 = se4.iterator();
		while (itt3.hasNext()) {
			String temp = itt3.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				dii = dii + "0" + temp + " ";
			} else {
				dii = dii + temp + " ";
			}
		}
		System.out.println();
		System.out.println("机选号码为：");
		Set<Integer> set = new TreeSet();
		while (set.size() < 5) {
			set.add((int) (Math.random() * 35 + 1));
		}
		Iterator ii = set.iterator();
		int t1 = 1;
		while (ii.hasNext()) {
			String temp = ii.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				jii = jii + "0" + temp + " ";
			} else {
				jii = jii + temp + " ";
			}
			t1++;
		}
		Set<Integer> set1 = new TreeSet();
		while (set1.size() < 2) {
			set1.add((int) (Math.random() * 12 + 1));
		}
		Iterator iii = set1.iterator();
		while (iii.hasNext()) {
			String temp = iii.next().toString();
			int temp1 = temp.length();
			if (temp1 == 1) {
				jii = jii + "0" + temp + " ";
			} else {
				jii = jii + temp + " ";
			}
		}
		ActionContext.getContext().getApplication().put("gao", gaoo);
		ActionContext.getContext().getApplication().put("di", dii);
		ActionContext.getContext().getApplication().put("ji", jii);
		return SUCCESS;
	}
}
