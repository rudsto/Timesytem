<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Timeregistrering</title>
</head>
<body>
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
<!-- <fieldset>
    <h1>Timer registrert </h1>
    <p>Prosjekt ID: ${time.prosjekt_id}</p>
    <p>Prosjektnavn: ${prosjekt.navn}</p>
    <p>Antall timer: ${time.antallTimer}</p>
</fieldset> -->

<form action="${pageContext.request.contextPath}/registrertime" method="post">
    <fieldset id="rot">

        <label>Prosjekt ID<br>
            <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt_id}"/><br></label>

        <label>Antall timer<br>
            <input type="text" name="antallTimer" id="antallTimer" value="${antallTimer}"/><br></label>

        <br>
        <button id="submit-btn" type="submit">Registrer</button>

    </fieldset>
</form>

</body>
</html>
