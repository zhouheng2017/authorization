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
    <title>ListUsers</title>
   <%-- <script type="text/javascript" src="/script/jquery-2.0.2.min.js"/>

    <script type="text/javascript">

        $(function() {
                $(".delete").click(function () {

                    var href = $(this).attr("href");
                    $("form").attr("action", href).submit();
                    return false;
                });

            }
        )
    </script>--%>
</head>
<body>

<%--<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
</form>--%>
<br/><br/>

<center>
    <h3>所有的用户</h3>


        <table cellspacing="0" cellpadding="10" border="1">
            <thead>
            <tr>

                <th>角色id</th>
                <th>角色名字</th>
                <th>email</th>
                <th>phone</th>
                <th>角色列表</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>

                    <td>${user.userId}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.phone }</td>

                    <td>
                        <form action="/authorization/role/${user.userId}" method="post">


                        <c:forEach items="${roles}" var="role">

                            <input type="checkbox" name="AuthorizationRole" value="${role.roleId}">${role.roleName}

                        </c:forEach>


                            <input type="submit" value="Authorization">
                        </form>
                    </td>
                    <br/><br/>


                </tr>



            </c:forEach>
            </tbody>
        </table>




</center>
</body>
</html>
