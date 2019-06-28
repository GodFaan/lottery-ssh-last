<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome our respectful and dear customer!</title>
</head>
<body>
	
	<h1 >恭喜您登陆成功，你可以进行一下操作!</h1>
	<br>
		<s:form action="showLottery" namespace="/">
			<s:submit value="查看近期开奖结果" />
			<s:token></s:token>
		</s:form>
	</br>
	<br>
	<s:form action="buyLottery" namespace="/">
			<s:submit value="前往购彩页面" />
			<s:token></s:token>
	</s:form>
	</br>
	<br>
	<s:form action="showCart" namespace="/">
			<s:submit value="查看购物车" />
	</s:form>
	<br>
	<s:form action="jumpToHistory" namespace="/">
			<s:submit value="查看购彩历史" />
	</s:form>
	<br>
	<s:form action="userExit" namespace="/">
			<s:submit value="退出" />
	</s:form>
</body>
</html>