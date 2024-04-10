<%--
  Created by IntelliJ IDEA.
  User: oyvin
  Date: 10.04.2024
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slett prosjekt</title>
</head>
<body>

<H2>Slett prosjekt</H2>
<p style="color:red;">${feilmeldinger}</p>

<form >
    <fieldset>
        <label>Prosjekt Id<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt.prosjekt_id}"/><br>
        </label>
    </fieldset>
</form>

<h3>Registrerte prosjekter</h3>
<table>
    <tr>
        <th align="left">Prosjekt id</th>
        <th align="left">Navn</th>
    </tr>
    <c:forEach var="prosjekt" items="${prosjekter}">
        <tr>
            <td>${prosjekt.prosjekt_id}</td>
            <td>${prosjekt.navn}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
