<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/27
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系人信息</title>
</head>
<body>
<c:forEach varStatus="conStatus" items="${list}" var="contact">
    <table border="1" align="center" width="600px">
        <tr align="center">
            <td>姓名</td>
            <td>${contact.name}</td>
        </tr>
        <tr align="center">
            <td>年龄</td>
            <td>${contact.age}</td>
        </tr>
        <tr align="center">
            <td>性别</td>
            <td>${contact.gender}</td>
        </tr>
        <tr align="center">
            <td>电话</td>
            <td>${contact.phone}</td>
        </tr>
        <tr align="center">
            <td>QQ</td>
            <td>${contact.qq}</td>
        </tr>
        <tr align="center">
            <td>邮箱</td>
            <td>${contact.email}</td>
        </tr>
    </table>
</c:forEach>
<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/ListContact.jsp">返回</a>
</div>
</tr>
</body>
</html>
