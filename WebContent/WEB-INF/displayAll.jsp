<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示会员信息</title>
</head>
<body>
	<h4>会员信息</h4>
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
		</span> <span>--------------********--------------</span>
	</div>
	<table border='1'>
		<tr>
			<td>会员id</td>
			<td>会员名</td>
			<td>密码</td>
			<td>性别</td>
			<td>邮箱</td>
			<td>电话号码</td>
			<td>个人简介</td>
			<td>注册日期</td>
			<td>删除</td>
		</tr>
		<%--   <s:iterator value="#request.userList" id="us"> --%>
		<s:iterator value="#request['userList']" id="user">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="gender" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="telephone" /></td>
				<td><s:property value="introduce" /></td>
				<td><s:property value="startdate" /></td>

				<td><a
					href="<s:url action="userDelete"><s:param name="user.id"><s:property value="id"/></s:param>
                        </s:url>">删除</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>