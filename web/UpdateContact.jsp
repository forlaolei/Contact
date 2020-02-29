<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/28
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改联系人</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpdateContact?userName=${pageContext.request.getParameter("userName")}"
      method="post">
    <table border="1" align="center" width="400px">
        <tr>
            <td>
                <%-- 使用隐藏域 --%>
                <input type="hidden" name="id" value="${pageContext.request.getParameter("id")}">
            </td>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td><input type="text" name="name" value="${pageContext.request.getParameter("name")}"></td>
        </tr>
        <tr>
            <td align="center">年龄</td>
            <td><input type="text" name="age" value="${pageContext.request.getParameter("age")}"></td>
        </tr>
        <tr>
            <td align="center">性别</td>
            <td>男<input type="radio" name="gender" value="男" checked>
                女<input type="radio" name="gender" value="女">
            </td>
        </tr>
        <tr>
            <td align="center">电话</td>
            <td><input type="text" name="phone" value="${pageContext.request.getParameter("phone")}"></td>
        </tr>
        <tr>
            <td align="center">QQ</td>
            <td><input type="text" name="qq" value="${pageContext.request.getParameter("qq")}"></td>
        </tr>
        <tr>
            <td align="center">邮箱</td>
            <td><input type="text" name="email" value="${pageContext.request.getParameter("email")}"></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="submit" value="确定"/>
                <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
