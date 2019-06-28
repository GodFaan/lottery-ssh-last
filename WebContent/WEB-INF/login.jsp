<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员登录</title>
</head>
<body>
<h1>尊敬的会员，欢迎您来到本站，您可以登录或者注册！</h1>
	<!-- 输出相关错误信息 -->
	<s:actionerror />
	<s:form action="userLogin" method="post">
		<s:textfield name="user.name" label="会员姓名"></s:textfield>
		<s:password name="user.password" label="会员口令"></s:password>
		<s:submit value="提交"></s:submit>
		<s:token></s:token>
	</s:form>
	<s:form action="jumpToRegister"><!-- 这一步是要跳转到用户注册页面的 -->
		<s:submit value="点此进行注册！"></s:submit>
		<s:token></s:token>
	</s:form>

	<s:form action="beforeAdminLogin" >
		<s:submit value="管理员登录入口！"></s:submit>
		<s:token></s:token>
	</s:form>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>