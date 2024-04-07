<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>Opprett prosjekt</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/opprettprosjekt" method="post">
    <fieldset id="rot">

        <label>Prosjekt Id<br>
            <input type="text" name="prosjektid" id="prosjektid" value="${prosjekt.prosjekt_id}"/><br>
        </label>

        <label>Navn<br>
            <input type="text" name="prosjektnavn" id="prosjektnavn" value="${prosjekt.navn}"/><br>
        </label>

        <br>

        <button id="submit-btn" type="submit">Opprett prosjekt</button>

    </fieldset>
</form>
</body>
</html>
