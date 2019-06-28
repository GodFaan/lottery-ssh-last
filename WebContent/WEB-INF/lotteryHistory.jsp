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
	<s:form action="userExit" namespace="/">
		<s:submit value="退出" />
	</s:form>
	<s:form action="jumpToUserPage" namespace="/">
		<s:submit value="跳到首页" />
	</s:form>
	<table border='1'>
		<tr>
			<td>彩票编号id</td>
			<td>彩票号码</td>
			<td>加入时间</td>
			<td>数目</td>
			<td>总价</td>
			<td>删除</td>
			<td>继续追号</td>
		</tr>
		<s:iterator value="#request['historylist']" id="history">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="number" /></td>
				<td><s:property value="adate" /></td>
				<td><s:property value="count" /></td>
				<td><s:property value="sum" /></td>

				<td><a
					href="<s:url action="deleteHistory"><s:param name="history.id"><s:property value="id"/></s:param>
                        </s:url>">删除记录</a>
				</td>
				<td><a
					href="<s:url action="addCartAgain"><s:param name="history.number"><s:property value="number"/></s:param>
                        </s:url>">继续追号</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>