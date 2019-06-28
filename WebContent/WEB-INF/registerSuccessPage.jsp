<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	<h1>恭喜您注册成功，成为我们尊贵的会员，祝你早日中奖！</h1>
	<s:form action="beforeUserLogin">
		<!-- 这一步跳转到管理员注册页面 -->
		<s:submit value="会员登录！"></s:submit>
		<s:token></s:token>
	</s:form>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>