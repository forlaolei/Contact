<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/28
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询联系人</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/QueryContact?userName=${pageContext.request.getParameter("userName")}"
      method="post">
    <table align="center" border="1" width="600px">
        <tr>
            <td align="center">输入要查询的联系人姓名</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="确定">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
