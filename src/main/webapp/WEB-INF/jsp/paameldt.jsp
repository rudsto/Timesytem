<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<table class="navbar">
    <tr>
        <td>
            <form action="/${pageContext.request.contextPath}/paamelding" method="get">
                <button type="submit">Registrer ny Bruker</button>
            </form>
        </td>
        <td>
            <form action="/${pageContext.request.contextPath}/logut" method="post">
                <button type="submit">Logg ut</button>
            </form>
        </td>
        <td>
            Du er logget inn som ${bruker.fornavn} ${bruker.etternavn}
        </td>
    </tr>
</table>

<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>

	<p> ${ansatt.fornavn} ${ansatt.etternavn} <br>
    	${ansatt.mobil} <br>   
	</p>

	<a href="/deltagerliste">Gå til aktivitetsvalg</a>
	
</body>
</html>
