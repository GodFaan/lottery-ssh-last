<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>
</head>
<body>
<h1>欢迎你管理员，你可以在下面输入账号密码实现登录！</h1>
<s:actionerror/>
	<s:form action="adminLogin" method="post">
		<s:textfield name="admin.name" label="管理员姓名"></s:textfield>
		<s:password name="admin.password" label="管理员口令"></s:password>
		<s:submit value="提交"></s:submit>
		<s:token></s:token>
	</s:form>

	<s:form action="beforeAdminRegister"><!-- 这一步跳转到管理员注册页面 -->
	<s:submit value="管理员资格注册！"></s:submit>
	<s:token></s:token>
	</s:form>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>