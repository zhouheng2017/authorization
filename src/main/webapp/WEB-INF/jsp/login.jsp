<%--
  Created by IntelliJ IDEA.
  User: zhouheng
  Date: 2018/6/3
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<center>
<form action="/user/judge" method="post">
    <table>
        <tr>
            <td width="80">用户名：</td>
            <td><input id="username" name="username" value="zhouheng2" style="width: 100px" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="password" name="password" value="123456" type="password" style="width: 100px" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <button type="submit" class="btn btn-primary">登录系统</button>
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
