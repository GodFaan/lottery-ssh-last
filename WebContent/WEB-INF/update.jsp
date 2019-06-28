<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改会员信息</title>
</head>
<body>
    <s:form action="userUpdate" method="post">
        <h4><s:text name="修改会员信息"></s:text></h4>
        <s:actionerror/>
        
        <s:hidden name="user.id" value="%{user.id}"></s:hidden>
        <s:textfield name="user.name" label="会员姓名" required="true"></s:textfield>
        <s:textfield name="user.password" label="会员口令"></s:textfield>
        <s:textfield name="user.gender" label="会员性别"></s:textfield>
        <s:textfield name="user.email" label="会员邮箱"></s:textfield>
        <s:textfield name="user.telephone" label="会员电话"></s:textfield>
        <s:textfield name="user.introduce" label="会员留言"></s:textfield>
        <s:submit value="提交"/>
        <s:token></s:token>
    </s:form>
    <%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>