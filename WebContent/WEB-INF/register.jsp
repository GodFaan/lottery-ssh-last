<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员注册页面</title>
</head>
<body>
	<s:actionerror />
	<h1>会员注册</h1>
	<s:form action="userRegister" method="post" namespace="/">
		<s:property value="exception.message" />
		<s:radio list="#{'male':'男'  , 'female':'女'  }" name="user.gender"></s:radio>
		<s:textfield name="user.name" label="会员姓名" required="true"></s:textfield>
		<s:password name="user.password" label="会员口令"></s:password>
		<s:textfield name="user.email" label="会员邮箱"></s:textfield>
		<s:textfield name="user.telephone" label="联系电话"></s:textfield>
		<s:textfield name="user.introduce" label="留言描述"></s:textfield>
		<s:submit value="提交" />
		<s:token></s:token><!-- 防止表单重复提交 -->
	</s:form>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>