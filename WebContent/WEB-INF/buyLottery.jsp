<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>彩票购买页面</title>
</head>
<body>
<s:form action="userExit" namespace="/">
		<s:submit value="退出" />
	</s:form>
	<s:form action="jumpToUserPage" namespace="/">
		<s:submit value="跳到首页" />
	</s:form>
	<br>
	<span>为您推荐的近期高频号码是：<s:property value="#application.gao" />
	</span>
	<br />
	<br />
	<br>
	<span>为您推荐的近期低频号码是：<s:property value="#application.di" />
	</span>
	<br />
	<br />
	<br>
	<span>为您推荐的幸运机选号码是：<s:property value="#application.ji" />
	</span>
	<br />
	<br />
	<s:form action="addCart" method="post" namespace="/">

		<span> <s:checkboxlist name="pre"
				list="{'01','02','03','04','05','06','07'}" label="前区选号(选五个)"></s:checkboxlist>
		</span>
		<span> <s:checkboxlist name="pre"
				list="{'08','09','10','11','12','13','14'}"></s:checkboxlist>
		</span>
		<span> <s:checkboxlist name="pre"
				list="{'15','16','17','18','19','20','21'}"></s:checkboxlist>
		</span>
		<span> <s:checkboxlist name="pre"
				list="{'22','23','24','25','26','27','28'}"></s:checkboxlist>
		</span>
		<span> <s:checkboxlist name="pre"
				list="{'29','30','31','32','33','34','35'}"></s:checkboxlist>
		</span>
		<s:checkboxlist name="aft" list="{'01','02','03','04','05','06'}"
			label="后区选号(选两个)"></s:checkboxlist>
		<s:checkboxlist name="aft" list="{'07','08','09','10','11','12'}"></s:checkboxlist>
		<s:textfield name="lotteryCart.count" label="购买注数"></s:textfield>
		<s:submit value="添加到购物车"></s:submit>
		<s:token></s:token>
	</s:form>
	<br />
	<br />
	<br />
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>