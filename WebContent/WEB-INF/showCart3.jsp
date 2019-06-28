<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车信息！</title>
</head>
<body>
<br><span><h1>您的购物车信息如下：</h1></span>
<br/>
<br/>
    <table border='1'>
        <tr>
            <td>彩票编号id</td><td>彩票号码</td><td>单价</td><td>预购数目</td><td>加入时间</td><td>总价</td><td>删除</td><td>购买</td>
        </tr>
          <%--   <s:iterator value="#request.userList" id="us"> --%>
            <s:iterator value="#request['cartlist']" id="lotteryCart">
                <tr>
                    <td><s:property value="bid"/></td>
                    <td><s:property value="number"/></td>
                    <td><s:property value="price"/></td>
                    <td><s:property value="count"/></td>
                    <td><s:property value="adate"/></td>
                    <td><s:property value="sum"/></td>
                    
                    <td>
                        <a href="<s:url action="cartDelete"><s:param name="lotteryCart.bid"><s:property value="bid"/></s:param>
                        </s:url>">删除</a>
                    </td>
                    <td>
                        <a href="<s:url action="addHistory"><s:param name="lotteryCart.bid"><s:property value="bid"/></s:param>
                        </s:url>">购买</a>
                    </td>
                </tr>
            </s:iterator>
    </table>
    <br>
	<s:form action="buyLottery" namespace="/">
			<s:submit value="前往购彩页面" />
			<s:token></s:token>
	</s:form>
	</br>
    <%@ include file="/WEB-INF/background.jsp"%>
</body>
</html>