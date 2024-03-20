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
    <title> TBA </title>
</head>
<body>

<h1>These are all the employees in the db currently: </h1>
<table>
    <tr>
        <th> id </th>
        <th> first name </th>
        <th> last name </th>
        <th> profession </th>
        <th> phone number </th>
    </tr>
    <c:forEach var="e" items="${emps}">
    <tr>
        <td>${e.employeeId}</td>
        <td>${e.firstName}</td>
        <td>${e.surname}</td>
        <td>${e.profession}</td>
        <td>${e.phone}</td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
