<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/27
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示联系人</title>
</head>
<body>
<div style="text-align: center;"><h3>显示联系人</h3></div>
<table align="center" border="1" width="800px">
    <tr>
        <th width="200px">编号</th>
        <th width="200px">姓名</th>
        <th width="200px">年龄</th>
        <th width="200px">性别</th>
        <th>电话</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach var="contact" items="${list}" varStatus="conStatus">
        <tr align="center">
            <td>${conStatus.count}</td>
            <td>${contact.name}</td>
            <td>${contact.age}</td>
            <td>${contact.gender}</td>
            <td>${contact.phone}</td>
            <td>${contact.qq}</td>
            <td>${contact.email}</td>
            <td width="300px">
                    <%-- 传递请求参数 --%>
                <a href="${pageContext.request.contextPath}/UpdateContact.jsp?id=${contact.id}&name=${contact.name}&
age=${contact.age}&gender=${contact.gender}&phone=${contact.phone}&qq=${contact.qq}&email=${contact.email}">修改</a>
                <a href="${pageContext.request.contextPath}/DeleteContact?id=${contact.id}">&nbsp;删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td align="center" colspan="8">
            <a href="${pageContext.request.contextPath}/addContact.jsp?">[添加联系人]</a>
            <a href="${pageContext.request.contextPath}/QueryContact.jsp">&nbsp;&nbsp;&nbsp;[查询联系人]</a>
        </td>
    </tr>
</table>
</body>
</html>
