<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>Opprett prosjekt</title>
</head>

<body>

<h2>Opprett nytt prosjekt</h2>
<p style="color:red;">${feilmeldinger}</p>

<form action="${pageContext.request.contextPath}/opprettprosjekt" method="post">
    <fieldset id="rot">

        <label>Prosjekt Id<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt.prosjekt_id}"/><br>
        </label>

        <label>Navn<br>
            <input type="text" name="navn" id="navn" value="${prosjekt.navn}"/><br>
        </label>

        <br>

        <button id="submit-btn" type="submit">Opprett prosjekt</button>

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
