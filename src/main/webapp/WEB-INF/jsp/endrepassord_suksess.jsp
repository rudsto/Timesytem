<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Endre passord</title>
</head>
<body>

<h2>Endre passord</h2>
<p style="color:green;">Passord endret! ;)</p>

<fieldset>
	<table class="navbar">
    	<tr>
       		<td>
           		<form method="post" action="${pageContext.request.contextPath}/endrepassord_suksess">
        			<button id="submit-btn" type="submit">Gå videre</button>
				</form>
        	</td>
    	</tr>
	</table>  
</fieldset>

</body>
</html>