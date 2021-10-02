/**
 * 
 */
$(document).ready(function(){
	
		$("#listarU").click(function(){
			$.get("http://localhost:8080/listausuarios", function(data, status){
				if(status=="success"){
					let longitud = data.length;
					let salida ="<table border='1'>";					
					salida = salida + "<tr><th>ID</th><th>USUARIO</th><th>PASSWORD</th><th>CEDULA</th><th>NOMBRE</th><th>EMAIL</th></tr>";
					for(let i=0;i<longitud;i++){
						salida = salida + "<tr>";
						salida = salida + "<td>"+data[i].id_usuario+"</td>";
						salida = salida + "<td>"+data[i].usuario+"</td>";
						salida = salida + "<td>"+data[i].password+"</td>";
						salida = salida + "<td>"+data[i].cedula_usuario+"</td>";
						salida = salida + "<td>"+data[i].nombre_usuario+"</td>";
						salida = salida + "<td>"+data[i].email_usuario+"</td>";
						salida = salida + "</tr>";
											}
					salida=salida+"</table>";
					$("#mensaje").html(salida);
										
				}
			});
		});

		$("#buscarU").click(function(){
			let elid =$("#id_usuario").val();
			$.post("http://localhost:8080/buscarusuarioID",{id_usuario: elid},
			function(data, status){
				let longitud = data.length;
				if (longitud>0){//Consutar un usuario devuelve un arreglo con posición 0
					$("#id_usuario").val(data[0].id_usuario);
 					$("#usuario").val(data[0].usuario);
					$("#password").val(data[0].password);
					$("#cedula_usuario").val(data[0].cedula_usuario);
					$("#nombre_usuario").val(data[0].nombre_usuario);
					$("#email_usuario").val(data[0].email_usuario);
					
				}else{
					$("#mensaje").html("<b sytle='color:red'>USUARIO NO ENCONTRADO !!!</b>");
				}
			});
		});


		$("#agregarU").click(function(){
			let elid = $("#id_usuario").val();
			let elusuario =$("#usuario").val();
			let laclave = $("#password").val();
			let lacedula = $("#cedula_usuario").val();
			let elnombre = $("#nombre_usuario").val();
			let elemail = $("#email_usuario").val();
	
			$.post("http://localhost:8080/crearusuario",{id_usuario: elid, usuario: elusuario, password: laclave, cedula_usuario: lacedula, nombre_usuario: elnombre, email_usuario: elemail }, 
			function(data,status){
				if(data==true){
					$("#mensaje").html("El usuario fue creado .");
				}else{
					$("#mensaje").html("<b style='color:red'>No se puede crear, ya existe!!!</b>");
				} 
			});
		});
		
		$("#actualizarU").click(function(){
			let elid = $("#id_usuario").val();
			let elusuario =$("#usuario").val();
			let laclave = $("#password").val();
			let lacedula = $("#cedula_usuario").val();
			let elnombre = $("#nombre_usuario").val();
			let elemail = $("#email_usuario").val();
			
			
			$.post("http://localhost:8080/actualizarusuario",{id_usuario: elid, usuario: elusuario, password: laclave, cedula_usuario: lacedula, nombre_usuario: elnombre, email_usuario: elemail}, function(data,status){
				if(data==true){
					$("#mensaje").html("El usuario fue actualizado .");
				}else{
					$("#mensaje").html("<b style='color:red'>No se puede actualizar, no existe!!!</b>");
				}
			});
		});

		$("#eliminarU").click(function(){
			let elid = $("#id_usuario").val();
			$.post("http://localhost:8080/borrarusuario",{id_usuario: elid}, function(data,status){
				if(data==true){
				$("#mensaje").html("El usuario fue eliminado .");
			}else{
				$("#mensaje").html("<b style='color:red'>No se puede eliminar, no existe!!!</b>");
			} }); }); });