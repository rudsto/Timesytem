<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<p style="color:red;">${loginMelding}</p>
	<form id="login" action="login" method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit" >Log in</button>
		</fieldset>
	</form>

</body>
</html>