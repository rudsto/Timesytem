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
<p style="color:green;">${suksessmelding}</p>

<form action="${pageContext.request.contextPath}/slettprosjekt" method="post" id="slettProsjektForm">
    <fieldset>
        <label>Prosjekt Id<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt.prosjekt_id}"/><br>
        </label>
        <br>
        <!--
        <label>
            <input type="checkbox" name="deleteTimereg" id="deleteTimeregCheckbox"/>
            Slett også tilhørende timer
        </label>
        <br>
        -->
        <button type="submit" id="slettProsjektBtn">Slett prosjekt</button>
    </fieldset>
</form>

<button onclick="location.href='${pageContext.request.contextPath}/deltagerliste'" type="button">Til hovedsiden</button>

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

<script>
    document.getElementById("slettProsjektBtn").addEventListener("click", function (event) {
        var confirmDelete = confirm("Er du sikker på at du vil slette prosjektet?");
        //var deleteTimeregCheckbox = document.getElementById("deleteTimeregCheckbox").checked;
        if (confirmDelete === true) {
            /*
            if(deleteTimeregCheckbox === true) {
                var confirmDelTimereg = confirm("Er du sikker på at du også vil slette timene?")
                if (confirmDelTimereg === false) {
                    document.getElementById("deleteTimeregCheckbox").checked = false;
                }
            }
             */
            document.getElementById("slettProsjektForm").submit();
        } else {
            event.preventDefault(); // For å forhindre standard oppførsel av knappen (form submission)
        }
    });
</script>

</body>
</html>
