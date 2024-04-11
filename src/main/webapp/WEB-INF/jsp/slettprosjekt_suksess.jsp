
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prosjekt slettet</title>
</head>
<body>

<h1>Prosjekt slettet</h1>
<p>Prosjekt ID ${prosjekt.prosjekt_id}</p>
<p>Prosjektnavn: ${prosjekt.navn}</p>

<table class="navbar">
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/slettprosjekt" method="get">
                <button type="submit">Slett nytt prosjekt</button>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/deltagerliste" method="get">
                <button type="submit">Til hovedsiden</button>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/logut" method="post">
                <button type="submit">Logg ut</button>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
