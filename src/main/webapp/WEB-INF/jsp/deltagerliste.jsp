<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Brukervalg</title>
</head>
<body>

<p>Innlogget som: ${bruker.mobil} / ${bruker.fornavn} ${bruker.etternavn}</p>
<br>

<h2>Prosjektvalg</h2>
<table class="navbar">
    <tr>
        <td>
    		<button onclick="location.href='${pageContext.request.contextPath}/opprettprosjekt'" type="button">Opprett prosjekt</button>
        </td>
        <td>
            <button onclick="location.href='${pageContext.request.contextPath}/redigerprosjekt'" type="button">Rediger prosjekt</button>
        </td>
        <td>
            <button onclick="location.href='${pageContext.request.contextPath}/slettprosjekt'" type="button">Slett prosjekt</button>
        </td>
    </tr>
</table>

<h2>Timehåndteringsvalg</h2>
<table class="navbar">
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/registrertime" method="get">
    			<button type="submit">Registrer time</button>
			</form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/redigertimer" method="get">
                <button type="submit">Rediger/slett time</button>
            </form>
        </td>
    </tr>
</table>
<br>

<h3>Brukere online</h3>
<table>
    <tr>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>
    <c:forEach var="ansatt" items="${ansatte}">
        <tr style=<c:if test="${ansatt.mobil eq bruker.mobil}">"background-color:#418941"</c:if>>
            <td>${ansatt.fornavn} ${ansatt.etternavn}</td>
            <td>${ansatt.mobil}</td>
        </tr>
    </c:forEach>
</table>
<br>

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
<br>

<h3>Registrerte timer</h3>
<table>
    <tr>
        <th align="left">Time id</th>
        <th align="left">Antall</th>
        <th align="left">Mobil</th>
        <th align="left">Prosjekt id</th>
    </tr>
    </tr>
        <c:forEach var="time" items="${timeliste}">
            <tr>
                <td>${time.time_id}</td>
                <td>${time.antallTimer}</td>
                <td>${time.bruker.mobil}</td>
                <td>${time.prosjekt.prosjekt_id}</td>
            </tr>
        </c:forEach>
</table>
<br>

<div class="tab">
    <button class="tablinks" onclick="expandView()">Brukere online</button>
</div>


<form action="${pageContext.request.contextPath}/logut" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>
