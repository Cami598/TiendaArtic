/**
 * 
 */
$(document).ready(function(){
	
		$("#listarC").click(function(){
			$.get("http://localhost:8080/listaclientes", function(data, status){
				if(status=="success"){
					let longitud = data.length;
					let salida ="<table border='1'>";					
					salida = salida + "<tr><th>CEDULA</th><th>DIRECCION</th><th>EMAIL</th><th>NOMBRE</th><th>TELEFONO</th></tr>";
					for(let i=0;i<longitud;i++){
						salida = salida + "<tr>";
						salida = salida + "<td>"+data[i].cedula_cliente+"</td>";
						salida = salida + "<td>"+data[i].direccion_cliente+"</td>";
						salida = salida + "<td>"+data[i].email_cliente+"</td>";
						salida = salida + "<td>"+data[i].nombre_cliente+"</td>";
						salida = salida + "<td>"+data[i].telefono_cliente+"</td>";
						
						salida = salida + "</tr>";
											}
					salida=salida+"</table>";
					$("#mensaje").html(salida);
										
				}
			});
		});

		$("#buscarC").click(function(){
			let elid =$("#cedula_cliente").val();
			$.post("http://localhost:8080/buscarcliente",{cedula_cliente: elid},
			function(data, status){
				let longitud = data.length;
				if (longitud>0){//Consutar un cliente devuelve un arreglo con posición 0
					$("#cedula_cliente").val(data[0].cedula_cliente);
					$("#nombre_cliente").val(data[0].nombre_cliente);
 					$("#direccion_cliente").val(data[0].direccion_cliente);
					$("#email_cliente").val(data[0].email_cliente);					
					$("#telefono_cliente").val(data[0].telefono_cliente);
					
					
				}else{
					$("#mensaje").html("<b sytle='color:red'>CLIENTE NO ENCONTRADO !!!</b>");
				}
			});
		});


		$("#agregarC").click(function(){
			let elid = $("#cedula_cliente").val();
			let ladireccion =$("#direccion_cliente").val();
			let elemail = $("#email_cliente").val();
			let elnombre = $("#nombre_cliente").val();
			let eltelefono = $("#telefono_cliente").val();
	
			$.post("http://localhost:8080/crearcliente",{cedula_cliente: elid, direccion_cliente: ladireccion, email_cliente: elemail, nombre_cliente: elnombre, telefono_cliente: eltelefono }, 
			function(data,status){
				if(data==true){
					$("#mensaje").html("El cliente fue creado .");
				}else{
					$("#mensaje").html("<b style='color:red'>No se puede crear, ya existe!!!</b>");
				} 
			});
		});
		
		$("#actualizarC").click(function(){
			let elid = $("#cedula_cliente").val();
			let ladireccion =$("#direccion_cliente").val();
			let elemail = $("#email_cliente").val();
			let elnombre = $("#nombre_cliente").val();
			let eltelefono = $("#telefono_cliente").val();
			
			
			$.post("http://localhost:8080/actualizarcliente",{cedula_cliente: elid, direccion_cliente: ladireccion, email_cliente: elemail, nombre_cliente: elnombre, nombre_usuario: elnombre, telefono_cliente: eltelefono },  function(data,status){
				if(data==true){
					$("#mensaje").html("El cliente fue actualizado .");
				}else{
					$("#mensaje").html("<b style='color:red'>No se puede actualizar, no existe!!!</b>");
				}
			});
		});

		$("#eliminarC").click(function(){
			let elid = $("#cedula_cliente").val();
			$.post("http://localhost:8080/borrarcliente",{cedula_cliente: elid}, function(data,status){
				if(data==true){
				$("#mensaje").html("El cliente fue eliminado .");
			}else{
				$("#mensaje").html("<b style='color:red'>No se puede eliminar, no existe!!!</b>");
			} }); }); });