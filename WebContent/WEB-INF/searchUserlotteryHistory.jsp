<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是***${requestScope.name}***的相关信息</h1>
	<div>
		<span>--------------********--------------</span> <span> <s:form
				action="jumptoAdminManagePage" namespace="/">
				<s:submit value="前往管理界面" />
				<s:token></s:token>
			</s:form>
		</span> <span> <s:form action="adminExit" namespace="/">
				<s:submit value="退出" />
				<s:token></s:token>
			</s:form>
		</span><span>--------------********--------------</span>
	</div>

	<h1>注册信息</h1>
	<table border='1'>
		<tr>
			<td>注册编号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>性别</td>
			<td>邮箱</td>
			<td>电话</td>
			<td>简介</td>
			<td>注册日期</td>
		</tr>
		<tr>
			<td><s:property value="id" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="password" /></td>
			<td><s:property value="gender" /></td>
			<td><s:property value="email" /></td>
			<td><s:property value="telephone" /></td>
			<td><s:property value="introduce" /></td>
			<td><s:property value="startdate" /></td>
		</tr>
	</table>



	<s:actionerror />

	<h1>购彩历史记录</h1>
	<table border='1'>
		<tr>
			<td>彩票编号id</td>
			<td>彩票号码</td>
			<td>加入时间</td>
			<td>数目</td>
			<td>总价</td>
		</tr>
		<s:iterator value="#request['historylist']" id="history">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="number" /></td>
				<td><s:property value="adate" /></td>
				<td><s:property value="count" /></td>
				<td><s:property value="sum" /></td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>