<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Brukervalg</title>
    <script defer src="js/deltagerliste.js"></script>
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
            <button onclick="location.href='${pageContext.request.contextPath}/redigerProsjekt'" type="button">Rediger prosjekt</button>
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

<div class="tab">
    <button class="tablinks fa" onclick="expandView(event, 'Brukere')">Brukere online</button>
    <button class="tablinks fa" onclick="expandView(event, 'Prosjekter')">Registrerte prosjekter</button>
    <button class="tablinks fa" onclick="expandView(event, 'Timer')">Registrerte timer</button>
</div>

<!-- Tab content -->
<div id="Brukere" class="tabcontent">
    <div class="center">
    <table class = "db_data">
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
    </div>

</div>

<div id="Prosjekter" class="tabcontent">
    <div class="center">
    <table class = "db_data">
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
    </div>

</div>

<div id="Timer" class="tabcontent">
    <div class = "center">
    <table class = "db_data">
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
    </div>
</div>

<br>

<div class="center">
    <form action="${pageContext.request.contextPath}/logut" method="post">
        <button class="logout fa fa-sign-out center" type="submit"> Logg ut </button>
    </form>
</div>
</body>
</html>
