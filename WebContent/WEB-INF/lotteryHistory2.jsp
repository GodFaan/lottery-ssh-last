<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>你还没有购买过相关商品，所以你的购物历史是空的</h1>
你可以：
<br>
	<s:form action="buyLottery" namespace="/">
			<s:submit value="前往购彩页面" />
			<s:token></s:token>
	</s:form>
    <%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>