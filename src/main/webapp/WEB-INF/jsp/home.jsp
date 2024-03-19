<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 3/13/24
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fuck you</title>
</head>
<body>

<h1>hello world</h1>
<table>
    <tr>
        <th> id </th>
        <th> name </th>
        <th> phone number </th>
    </tr>
    <c:ForEach var="e" items="${emps}">
    <tr>
        <td>${e.firstName}</td>
    </tr>
    </c:ForEach>

</table>

</body>
</html>
