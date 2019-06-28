<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员注册页面</title>
</head>
<body>
	<s:actionerror />
	<h1>管理员注册</h1>
	<s:form action="adminRegister" method="post" namespace="/">
		<s:property value="exception.message" />
		<s:textfield name="admin.name" label="账户名" required="true"></s:textfield>
		<s:password name="admin.password" label="登录密码"></s:password>
		<s:submit value="提交" />
		<s:token></s:token>
	</s:form>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>