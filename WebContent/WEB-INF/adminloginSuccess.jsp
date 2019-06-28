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

	<h1>尊敬的管理员，欢迎你登录，你可以在此页进行相关操作！</h1>
	<span> <s:form action="adminExit" namespace="/">
			<s:submit value="退出" />
			<s:token></s:token>
		</s:form>
	</span>
	<br>
	<s:actionerror />
	<h1>查找所有注册用户</h1>
	<s:form action="userQuery" namespace="/">
		<s:submit value="查找" />
		<s:token></s:token>
	</s:form>
	<br>
	<h1>查看所有管理员信息</h1>
	<s:form action="adminQuery" namespace="/">
		<s:submit value="查找" />
		<s:token></s:token>
	</s:form>
	<br>
	<h1>根据用户信息查找用户信息</h1>
	<s:form action="searchForUser" namespace="/">
		<s:textfield name="user.name" label="客户姓名"></s:textfield>
		<s:submit value="查找" />
		<s:token></s:token>
	</s:form>

</body>
</html>