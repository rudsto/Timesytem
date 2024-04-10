<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">

<head>
    <title>Timeredigering</title>
</head>
<body>
<script src="js/timevalidering.js" defer></script>
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

<h2>Timeredigering</h2>
<p style="color:red;">${feilmelding}</p>

<fieldset id="rot">

    <c:choose>
        <c:when test="${prosjekt eq null}">

            <form action="${pageContext.request.contextPath}/velgprosjekt" method="post">

                <label>Prosjekt ID<br>
                    <input type="text" name="prosjekt_id" id="prosjekt_id" value="${prosjekt_id}"/><br></label>

                <br>
                <button id="submit-btn" type="submit">Velg prosjekt</button>

            </form>

        </c:when>
        <c:otherwise>

            <form action="${pageContext.request.contextPath}/redigertime" method="post">

                <label>Nytt antall timer<br>
                    <input type="text" name="antallTimer" id="antallTimer" value="${antallTimer}"/><br></label>

                <br>
                <button id="redigertime" type="submit">Lagre endringer</button>

            </form>

            <form action="${pageContext.request.contextPath}/sletttime" method="post">

                <br>
                <button type="submit">Slett time</button>

            </form>

        </c:otherwise>
    </c:choose>
</fieldset>

<h3>Registrerte timer på ${prosjekt.prosjekt_id}</h3>
<table>
    <tr>
        <th align="left">Time id</th>
        <th align="left">Antall</th>
    </tr>
    </tr>
    <c:forEach var="time" items="${timeliste1}">
        <tr>
            <td>${time.time_id}</td>
            <td>${time.antallTimer}</td>
        </tr>
    </c:forEach>
</table>

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
