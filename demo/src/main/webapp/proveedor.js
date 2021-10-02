/**
 * 
 */
$(document).ready(function(){
	
		$("#listarP").click(function(){
			$.get("http://localhost:8080/listaproveedores", function(data, status){
				if(status=="success"){
					let longitud = data.length;
					let salida ="<table border='1'>";					
					salida = salida + "<tr><th>NIT</th><th>NOMBRE</th><th>DIRECCION</th><th>TELEFONO</th><th>CIUDAD</th></tr>";
					for(let i=0;i<longitud;i++){
						salida = salida + "<tr>";
						salida = salida + "<td>"+data[i].nit+"</td>";
						salida = salida + "<td>"+data[i].nombre_proveedor+"</td>";
						salida = salida + "<td>"+data[i].direccion_proveedor+"</td>";
						salida = salida + "<td>"+data[i].telefono_proveedor+"</td>";
						salida = salida + "<td>"+data[i].ciudad_proveedor+"</td>";
						
						salida = salida + "</tr>";
											}
					salida=salida+"</table>";
					$("#mensaje").html(salida);
										
				}
			});
		});

		$("#buscarP").click(function(){
			let elid =$("#nit").val();
			$.post("http://localhost:8080/buscarproveedor",{nit: elid},
			function(data, status){
				let longitud = data.length;
				if (longitud>0){//Consutar un proveedor devuelve un arreglo con posición 0
					$("#nit").val(data[0].nit);
					$("#nombre_proveedor").val(data[0].nombre_proveedor);
 					$("#direccion_proveedor").val(data[0].direccion_proveedor);
					$("#telefono_proveedor").val(data[0].telefono_proveedor);					
					$("#ciudad_proveedor").val(data[0].ciudad_proveedor);
					
					
				}else{
					$("#mensaje").html("<b sytle='color:red'>PROVEEDOR NO ENCONTRADO !!!</b>");
				}
			});
		});


		$("#agregarP").click(function(){
			let elid = $("#nit").val();
			let elnombre =$("#nombre_proveedor").val();
			let ladireccion = $("#direccion_proveedor").val();
			let eltelefono = $("#telefono_proveedor").val();
			let laciudad = $("#ciudad_proveedor").val();
	
			$.post("http://localhost:8080/crearproveedor",{nit: elid, nombre_proveedor: elnombre, direccion_proveedor: ladireccion, telefono_proveedor: eltelefono, ciudad_proveedor: laciudad }, 
			function(data,status){
				if(data==true){
					$("#mensaje").html("El Proveedor fue creado .");
				}else{
					$("#mensaje").html("<b style='color:red'>No se puede crear, ya existe!!!</b>");
				} 
			});
		});
		
		$("#actualizarP").click(function(){
			let elid = $("#nit").val();
			let elnombre =$("#nombre_proveedor").val();
			let ladireccion = $("#direccion_proveedor").val();
			let eltelefono = $("#telefono_proveedor").val();
			let laciudad = $("#ciudad_proveedor").val();
			
			
			$.post("http://localhost:8080/actualizarproveedor",{nit: elid, nombre_proveedor: elnombre, direccion_proveedor: ladireccion, telefono_proveedor: eltelefono, ciudad_proveedor: laciudad },  function(data,status){
				if(data==true){
					$("#mensaje").html("El proveedor fue actualizado .");
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