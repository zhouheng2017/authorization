<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouheng
  Date: 2018/6/4
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListRoles</title>
</head>
<body>
<br/><br/>

<center>
    <h3>所有的用户</h3>
<table cellspacing="0" cellpadding="10" border="1">
    <thead>
    <tr>
        <th>角色id</th>
        <th>角色名字</th>
        <th>角色title</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td>${role.roleId }</td>
            <td>${role.roleName}</td>
            <td>${role.title }</td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</center>
</body>
</html>
