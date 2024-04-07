
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prosjekt Opprettet</title>
</head>
<body>
<h1>Prosjekt opprettet</h1>
<p>Prosjekt ID: ${prosjekt.prosjekt_id}</p>
<p>Prosjektnavn: ${prosjekt.navn}</p>

<table class="navbar">
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/opprettprosjekt" method="get">
                <button type="submit">Registrer nytt prosjekt</button>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/logut" method="post">
                <button type="submit">Logg ut</button>
            </form>
        </td>
    </tr>
</table>

<a href="/deltagerliste">Gå til aktivitetsvalg</a>
</body>
</html>