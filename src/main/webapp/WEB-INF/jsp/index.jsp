<%@ page import="com.authorization.dto.AttributeValueDTO" %>
<%@ page import="com.authorization.model.User" %>
<%@ page import="com.authorization.model.Role" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouheng
  Date: 2018/6/3
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h2>欢迎你${username}</h2>
<%--<h3>${user}</h3>--%>

<h2>你的角色是</h2>
<%--<c:forEach items="${roles}" var="role">
    <tr>${role.roleId}</tr>
    <tr>${role.roleName}</tr>
    <tr>${role.title}</tr>
</c:forEach>--%>
<h3></h3>

<%
    User user = (User) session.getAttribute("user");

/*    List<Role> roleList = (List<Role>) session.getAttribute("roles");
    String roleString = "";
    for (Role role :
            roleList) {

        if (role.getRoleName().equals("ceo")) {
            roleString = role.getRoleName();
        }

    }*/
    AttributeValueDTO attributeValueDTO = new AttributeValueDTO(user.getEmail(), "jdbc:mysql://localhost:3306/how2java", "", "read:1-3");

    session.setAttribute("attributeValueDTO", attributeValueDTO);
%>

<center>
<table>
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
<br/><br/>
<a href="/users/listUsers">Authorization</a>
<br/>
<h3>subject:的属性   employee/manager/ceo</h3>
<br/>
<h3>resource:的属性  jdbc:mysql://localhost:3306/how2java</h3>
<br/>
<h3>action:的属性 read:1-3/read:2-3/read:4-7</h3>
<br/><br/>
<a href="/authorization/request/${user.userId}/employee">employee:read:1-3:"jdbc:mysql://localhost:3306/how2java"</a>
<br/><br/>
<a href="/authorization/request/${user.userId}/manager">manager:read:2-3:"jdbc:mysql://localhost:3306/how2java"</a>
<br/><br/>
<a href="/authorization/request/${user.userId}/ceo">ceo:read:4-7:"jdbc:mysql://localhost:3306/how2java"</a>
<br/><br/><br/><br/>
</center>
</body>
</html>
