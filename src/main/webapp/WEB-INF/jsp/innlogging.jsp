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

<h2>Logg inn</h2>
<p class = "feilmelding">${feilmelding}</p>

<fieldset>
	<legend>Logg in</legend>
	<table class="navbar">
    	<tr>
       		<td>
           		<form method="post" action="${pageContext.request.contextPath}/login">
       	 			<label for="mobil">Mobil:</label> <input type="text" name="mobil" id="mobil" value="${mobil}"/>
        			<label for="passord"> Passord:</label> <input type="password" name="passord" id="passord"/>
        			<button class="fa fa-sign-in sign-in" id="submit-btn" type="submit"> Logg inn </button>
				</form>
        	</td>
        	<td>
            	<form action="${pageContext.request.contextPath}/paamelding" method="get">
    				<button class = "fa fa-plus make-user" type="submit"> Opprett bruker </button>
    			</form>
        	</td>
    	</tr>
	</table>  
</fieldset>

<script src="js/validering.js" defer></script>

</body>
</html>
