//JQuery para capturar el servicio
$(document).ready(function(){
	$("#btn_Enviar").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
	let elUsuario =document.getElementById("usuario").value;//cada control de la pagina tiene un Id
	let laClave =document.getElementById("password").value;
	
	//esta varialbe contine el valor del campo cedula
	$.post("http://localhost:8080/loginusuario2",{usuario: elUsuario, password: laClave },
	
	function(data, status){
	// data1 = $.parseJSON( data );
	if(status="success"){
	let	 longitud=data.length;
	let salida="<table class='w3-table-all w3-hoverable w3-card-2'>";
	salida=salida+"<tr><th>USUARIO</th></tr>";
	for(let i=0;i<longitud;i++){
		//alert(data[i].elusuario);
		salida=salida+"<tr><td>"+data[i].usuario+"</td><td>";
		
		}
		salida = salida+ "</table>" ;
		$("#salida").html(salida);
	}else{
		let salida = "<tr><th>USUARIO INCORRECTO</th></tr>";
	}
				});
		});
	});
	
	