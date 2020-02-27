<%--
  Created by IntelliJ IDEA.
  User: 胡雷
  Date: 2020/2/27
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div style="text-align: center;"><h3>登录页面</h3></div>
<form action="${pageContext.request.contextPath}/DealLogin" method="post">
    <table align="center" border="1" width="400px">
        <tr>
            <th>用户名</th>
            <th align="left"><input type="text" name="userName"/></th>
        </tr>
        <tr>
            <th>密码</th>
            <th align="left"><input type="password" name="password"/></th>
        </tr>
        <tr>
            <th align="center" colspan="2"><input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </th>
        </tr>
    </table>

</form>
</body>
</html>
