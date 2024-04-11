<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">

<head>
    <title>Timeregistrering</title>
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<script src="js/timevalidering.js" defer></script>
<table class="navbar">
    <tr>
                <td>
                    <form action="/deltagerliste" method="get">
                        <button class="button-base" type="submit">Deltagerliste</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/logut" method="post">
                        <button class="fa fa-sign-out button-base logout" type="submit">Logg ut</button>
                    </form>
                </td>
    </tr>
</table>

<p class="feilmelding">${feilmelding}</p>

<fieldset id="rot">
    <legend>Timeregistrering</legend>
    <form action="${pageContext.request.contextPath}/registrertime" method="post">

        <label>Prosjekt ID<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt_id}"/><br></label>

        <label>Antall timer<br>
            <input type="text" name="antallTimer" id="antallTimer" value="${antallTimer}"/><br></label>

        <br>
        <button class="button-base make-user" id="submit-btn" type="submit">Registrer</button>

    </form>

    <c:if test="${prosjekt != null}">

        <h3>Vellykket registrering</h3>
        <p>Prosjekt ID: ${time.prosjekt.prosjekt_id}</p>
        <p>Prosjektnavn: ${prosjekt.navn}</p>
        <p>Antall timer: ${time.antallTimer}</p>

    </c:if>

</fieldset>

<h3>Registrerte prosjekter</h3>
<table class="db_data">
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
