<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/estiloindex.css">
<title>Insert title here</title>
</head>
<body>
	<form action="ControllerAcceso" method = "post">
	
	<div class="contendor">
		<label class="label">User</label>
		<br>
		<input class="cajatexto" type="text" name="user" placeholder="Escribe tu Usuario">
		<br>
		<label class="label">Pass</label>
		<br>
		<input class="cajatexto" type="text" name="pass" placeholder="Escribe tu contraseña">
		<br>
		<input class="cajatexto" type="submit">
	</div>
	</form>
</body>
</html>