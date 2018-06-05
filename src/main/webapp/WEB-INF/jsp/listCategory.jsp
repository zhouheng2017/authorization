<%@ page import="com.authorization.model.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouheng
  Date: 2018/3/15
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>ListCategory</title>
    <script type="text/javascript" src="/script/jquery-2.0.2.min.js"></script>



    <script type="text/javascript">

        $(function() {
                $(".delete").click(function () {

                    var href = $(this).attr("href");
                    $("form").attr("action", href).submit();
                    return false;
                });

            }
        )
    </script>
</head>
<body>

<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
</form>


<div style="width:500px;margin:0px auto;text-align:center">
    <table align="center" border="1" cellpadding="0">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Edit</td>
            <td>Delete</td>

        </tr>
            <c:forEach items="${cs}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><a href="/category/cs/${c.id}">Edit</a> </td>
                    <td><a class="delete" href="/category/cs/${c.id}">Delete</a> </td>

                </tr>
            </c:forEach>
    </table>
</div>
<div style="text-align: center">
    <a href="?start=0">首页</a>

    <a href="?start=${(page.start - page.count) < 0 ? 0:(page.start - page.count)}">上一页</a>

    <a href="?start=${page.start + page.count}">下一页</a>
    <a href="?start=${page.last}">末页</a>
</div>









</body>
</html>
