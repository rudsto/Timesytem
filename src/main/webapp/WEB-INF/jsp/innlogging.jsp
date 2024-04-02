<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logg inn</title>
</head>
<body>

<h2>Logg inn</h2>
<p style="color:red;">${feilmelding}</p>

<fieldset>
	<table class="navbar">
    	<tr>
       		<td>
           		<form method="post" action="/login">
       	 			<label for="mobil">Mobil:</label> <input type="text" name="mobil" id="mobil" value="${mobil}"/>
        			<label for="passord"> Passord:</label> <input type="password" name="passord" id="passord"/>
        			<button id="submit-btn" type="submit">Logg inn</button>
				</form>
        	</td>
        	<td>
            	<form action="/paamelding" method="get">
    				<button type="submit">Opprett bruker</button>
    			</form>
        	</td>
    	</tr>
	</table>  
</fieldset>

<script src="js/validering.js" defer></script>

</body>
</html>
