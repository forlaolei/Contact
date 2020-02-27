<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/27
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
<div style="text-align: center;"><h3>添加联系人</h3></div>
<form action="${pageContext.request.contextPath}/AddContact" method="post">
    <table border="1" width="400px" align="center">
        <tr>
            <td align="center">
                姓名
            </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="center">
                年龄
            </td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td align="center">
                性别
            </td>
            <td>
                男<input type="radio" name="gender" value="男" checked>
                女<input type="radio" name="gender" value="女">
            </td>
        </tr>
        <tr>
            <td align="center">
                电话
            </td>
            <td>
                <input type="text" name="phone">
            </td>
        </tr>
        <tr>
            <td align="center">
                QQ
            </td>
            <td>
                <input type="text" name="QQ">
            </td>
        </tr>
        <tr>
            <td align="center">
                Email
            </td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="确定">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/ListContact.jsp">返回</a>
</div>
</body>
</html>
