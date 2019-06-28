<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车信息！</title>
</head>
<body>
    <h1>对不起，您还没有添加任何商品到购物车！</h1>
    <br>
    您可以：
	<s:form action="buyLottery" namespace="/">
			<s:submit value="前往购彩页面进行购彩操作！" />
			<s:token></s:token>
	</s:form>
	</br>
	
    <%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>