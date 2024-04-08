<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">

<head>
    <title>Timeregistrering</title>
</head>
<body>
<script src="js/validering.js" defer></script>
<table class="navbar">
    <tr>
        <c:choose>
            <c:when test="${bruker eq null}">
                <td>
                    <form action="/login" method="get">
                        <button type="submit">Logg inn</button>
                    </form>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    <form action="/deltagerliste" method="get">
                        <button type="submit">Deltagerliste</button>
                    </form>
                </td>
                <td>
                    <form action="/logut" method="post">
                        <button type="submit">Logg ut</button>
                    </form>
                </td>
                <td>
                    Du er logget inn som ${bruker.fornavn} ${bruker.etternavn}
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</table>

<h2>Timeregistrering</h2>
<p style="color:red;">${feilmeldinger}</p>

<fieldset id="rot">
    <form action="${pageContext.request.contextPath}/registrertime" method="post">

        <label>Prosjekt ID<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt_id}"/><br></label>

        <label>Antall timer<br>
            <input type="text" name="antallTimer" id="antallTimer" value="${antallTimer}"/><br></label>

        <br>
        <button id="submit-btn" type="submit">Registrer</button>

    </form>

    <c:if test="${prosjekt != null}">

        <h3>Vellykket registrering</h3>
        <p>Prosjekt ID: ${time.prosjekt.prosjekt_id}</p>
        <p>Prosjektnavn: ${prosjekt.navn}</p>
        <p>Antall timer: ${time.antallTimer}</p>

    </c:if>

</fieldset>

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
