<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tienda Artic</title>
		<link href="login.css" rel="stylesheet" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		<script src="login.js"></script><!-- Incorporo al proyecto javascript -->
	</head>
	<body>
		<section id="formulario">
		<div class="contenedor">
		
		<form>
		<br><img src="./_logo_Artic.jpg">
		 <h2>BIENVENIDOS</h2>
			
					<input Id="usuario" type="text" value="" placeholder="Ingrese Usuario" required>
				
				
					
					<input Id="password" type="password" value="" placeholder="Ingrese Password" required>
				
				<input type="button" value="Aceptar" id="btn_Enviar"  >
				
				<!-- <tr><td><button id="btnEnviar" class="w3-button">Enviar</button></td></tr>-->
				

			</form>
		</div>
	</section>
		<br>
		<br>
		<!-- permite mostrar los datos del JSON -->
		<div id="salida">
		</div>
	</body>
</html>