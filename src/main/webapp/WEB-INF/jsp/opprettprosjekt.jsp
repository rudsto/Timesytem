<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>

    <title>Opprett prosjekt</title>
</head>

<body>
<form action="/paamelding" method="post">
    <fieldset id="rot">

        <label>Prosjekt Id<br>
            <input type="text" name="id" id="id" value="${prosjekt.id}"/><br>
        </label>

        <label>Navn<br>
            <input type="text" name="navn" id="navn" value="${prosjekt.navn}"/><br>
        </label>

        <br>
        <button id="submit-btn" type="submit">Opprett prosjekt</button>

    </fieldset>
</form>
</body>
</html>
