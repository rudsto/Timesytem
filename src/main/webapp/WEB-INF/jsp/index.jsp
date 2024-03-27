<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Index</title>
</head>
<body>
	<h2>Index</h2>
	<p> Navn: ${bruker.getFornavn()} ${bruker.getEtternavn()}</p>
	<p> Mobil: ${bruker.getMobil()}</p>
	<form id="logout" action="logout" method="post">
		<br><br><button type="submit" >Logg ut</button>
	</form>
</body>
</html>