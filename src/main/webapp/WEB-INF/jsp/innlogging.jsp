<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logg inn</title>
	<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="center">
<p class = "feilmelding">${feilmelding}</p>
</div>

<div class="center">
<fieldset>
	<legend class = "log-in-text">Logg in</legend>
	<table class="navbar">
    	<tr>

           		<form method="post" action="${pageContext.request.contextPath}/login">
					<div class = "new-line">
       	 				<label for="mobil">Mobil:</label>
						<input type="text" name="mobil" id="mobil" value="${mobil}"/>
					</div>
					<div class = "new-line">
        				<label for="passord"> Passord:</label>
						<input type="password" name="passord" id="passord"/>
					</div>
					<div class = "new-line center">
        				<button class="button-base fa fa-sign-in sign-in" id="submit-btn" type="submit"> Logg inn </button>
					</div>
				</form>


            	<form action="${pageContext.request.contextPath}/paamelding" method="get">
					<div class = "new-line center">
					<button class = "button-base fa fa-plus make-user" type="submit"> Opprett bruker </button>
					</div>
				</form>

    	</tr>
	</table>  
</fieldset>

</div>

<script src="js/validering.js" defer></script>

</body>
</html>
