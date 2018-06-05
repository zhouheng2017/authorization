<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouheng
  Date: 2018/3/15
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/category/cs/${category.id}" method="post"
           modelAttribute="category">

    <br/><br/>
    <c:if test="${category.id} !=null">
        <%--ID:<form:hidden path="${category.id}"/>--%>
        ID:<form:hidden path="${category.id}"/>
        <input type="hidden" value="PUT" name="_method"/>
        <br/><br/>
    </c:if>

    Name:<form:input path="name"/>

    <input type="submit" value="submit">


</form:form>

</body>
</html>
