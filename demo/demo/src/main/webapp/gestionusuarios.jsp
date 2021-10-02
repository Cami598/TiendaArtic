<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Control de Usuarios</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="gestionUsuarios.css" rel="stylesheet" type="text/css">
</head>
<body>
<H1><i class="fa fa-user"></i> Control de Usuarios</h1>
<i class="fa fa-spinner fa-spin fa-2x fa-fw"></i>
<div>
	<img id="logo" src="_logo_Artic.jpg"/>
</div>

<form>
	<table>
		<tr>
			<td><label>Cedula:</label></td>
			<td><input type="text" name="cedula"></td>
			<td><label > Usuario:</label></td>
			<td><input type="text" name="usuario"></td>
		</tr>
		<tr>
			<td><label>Nombre Completo:</label></td>
			<td><input type="text" name="nombre"></td>
			<td><label >Contraseña</label></td>
			<td><input type="password" name="contrasena"></td>
		</tr>
		<tr>
			<td><label>Correo electronico</label></td>
			<td><input id="mail" type="email" name="correo"></td>
		</tr>
		<tr>
			<td><input id="boton" type="submit" value="Consultar" ></td>
			<td><input id="boton" type="submit" value="Crear"></td>
			<td><input id="boton" type="submit" value="Actualizar"></td>
			<td><input id="boton" type="submit" value="Borrarr"></td>
		</tr>
	</table>
</form>
</body>
</html>