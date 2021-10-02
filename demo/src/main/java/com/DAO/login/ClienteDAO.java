package com.DAO.login;


import  java.sql.Statement;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.login.ClienteVO;


public class ClienteDAO {
	public ArrayList<ClienteVO> listaClientes(){
		ArrayList<ClienteVO> misClientes =new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes ");
			ResultSet res= consulta.executeQuery();
		while(res.next()){
			ClienteVO  Cliente = new ClienteVO();
			Cliente.setCedula_cliente(res.getLong("cedula_cliente"));
			Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
			Cliente.setEmail_cliente(res.getString("email_cliente"));
			Cliente.setNombre_cliente(res.getString("nombre_cliente"));
			Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
		
			misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
			return misClientes;
			}


	public ArrayList<ClienteVO> buscarCliente (long cedula_cliente){
		ArrayList<ClienteVO> misClientes =new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			consulta.setLong(1,cedula_cliente);	
			ResultSet res= consulta.executeQuery();
			while(res.next()){
				ClienteVO  Cliente = new ClienteVO();
				Cliente.setCedula_cliente(res.getLong("cedula_cliente"));
				Cliente.setNombre_cliente(res.getString("nombre_cliente"));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
				Cliente.setEmail_cliente(res.getString("email_cliente"));				
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				
				misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
		return misClientes;
			}
			
	 public boolean existeCliente(long cedula_cliente){
		boolean existe =false;
		Conexion conex = new Conexion();
		try{
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
		consulta.setLong(1,  cedula_cliente);
		ResultSet res= consulta.executeQuery();
			if(res.next()){
			existe=true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			}catch(Exception e){
			System.out.println("No se pudo verificar si existe el Usuario.");
			}
			return existe;
	}
	public boolean crearCliente(ClienteVO Cliente){
		boolean swCrear =false;
		if(!existeCliente(Cliente.getCedula_cliente())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="INSERT INTO clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) VALUES("+
				Cliente.getCedula_cliente()+",'"+Cliente.getDireccion_cliente()+"','"+Cliente.getEmail_cliente()+"','"+Cliente.getNombre_cliente()+"','"+Cliente.getTelefono_cliente()+"');";
		((java.sql.Statement) consulta).executeUpdate(SQL);
		((java.sql.Statement) consulta).close();
		conex.desconectar();
		swCrear=true;
			
			}catch(SQLException e){
				System.out.println("No se pudo crear el Cliente.");
				
			}
		}else{
				System.out.println("El cliente ya existe.");
			}
			return swCrear;
	}

	public boolean borrarCliente(Long cedula_cliente){
		boolean swBorrar =false;
		if(existeCliente(cedula_cliente)){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="DELETE FROM clientes WHERE cedula_cliente="+cedula_cliente;
		((java.sql.Statement)consulta).executeUpdate(SQL);
		((java.sql.Statement)consulta).close();
		conex.desconectar();
		swBorrar=true;

			
			}catch(SQLException e){
				System.out.println("No se pudo eliminar el Cliente.");
			
		}
			}else{
				System.out.println("El Cliente No existe.");
			}
			return swBorrar;
}
	public boolean actualizarCliente(ClienteVO Cliente){
		boolean swActualizar=false;
		if(existeCliente(Cliente.getCedula_cliente())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="UPDATE clientes SET cedula_cliente='" +Cliente.getCedula_cliente()+"',"+"direccion_cliente='"+Cliente.getDireccion_cliente()+"',"
				+"email_cliente='"+Cliente.getEmail_cliente()+"', "+"nombre_cliente='"+Cliente.getNombre_cliente()+"',"
				+ "telefono_cliente='"+Cliente.getTelefono_cliente()+"' WHERE cedula_cliente="+Cliente.getCedula_cliente();
		((java.sql.Statement) consulta).executeUpdate(SQL);
		((java.sql.Statement) consulta).close();
		conex.desconectar();
		swActualizar=true;
			
			}catch(SQLException e){
				System.out.println("No se pudo Actualizar el Usuario.");
			}
		}else{
				System.out.println("El usuario No existe.");
			}
			return swActualizar;
}
}
