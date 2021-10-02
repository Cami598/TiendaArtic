package com.DAO.login;

import  java.sql.Statement;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.login.UsuarioVO;


public class UsuarioDAO {

	public ArrayList<UsuarioVO> listaDeUsuarios(){
		ArrayList<UsuarioVO> misUsuarios =new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario ");
			ResultSet res= consulta.executeQuery();
		while(res.next()){
			UsuarioVO  Usuario = new UsuarioVO();
			Usuario.setId_usuario(res.getLong("id_usuario"));
			Usuario.setUsuario(res.getString("usuario"));
			Usuario.setPassword(res.getString("password"));
			Usuario.setCedula_usuario(res.getString("cedula_usuario"));
			Usuario.setNombre_usuario(res.getString("nombre_usuario"));
			Usuario.setEmail_usuario(res.getString("email_usuario"));
			misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
			return misUsuarios;
			}


	public ArrayList<UsuarioVO> buscarUsuario (long id_usuario){
		ArrayList<UsuarioVO> misUsuarios =new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE id_usuario=?");
			consulta.setLong(1,id_usuario);	
			ResultSet res= consulta.executeQuery();
			while(res.next()){
				UsuarioVO  Usuario = new UsuarioVO();
				Usuario.setId_usuario(res.getLong("id_usuario"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setCedula_usuario(res.getString("cedula_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
		return misUsuarios;
			}
			
	public boolean existeUsuario(long id_usuario){
		boolean existe =false;
		Conexion conex = new Conexion();
		try{
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE id_usuario=?");
		consulta.setLong(1,  id_usuario);
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
	public boolean crearUsuario(UsuarioVO Usuario){
		boolean swCrear =false;
		if(!existeUsuario(Usuario.getId_usuario())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="INSERT INTO usuario (id_usuario, cedula_usuario, nombre_usuario, email_usuario, usuario, password) VALUES("+
				Usuario.getId_usuario()+",'"+Usuario.getCedula_usuario()+"','"+Usuario.getNombre_usuario()+"','"+Usuario.getEmail_usuario()+"','"+Usuario.getUsuario()+"','"+Usuario.getPassword()+"');";
		((java.sql.Statement) consulta).executeUpdate(SQL);
		((java.sql.Statement) consulta).close();
		conex.desconectar();
		swCrear=true;
			
			}catch(SQLException e){
				System.out.println("No se pudo crear el Usuario.");
				
			}
		}else{
				System.out.println("El usuario ya existe.");
			}
			return swCrear;
	}

	public boolean borrarUsuario(Long id_usuario){
		boolean swBorrar =false;
		if(existeUsuario(id_usuario)){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="DELETE FROM usuario WHERE id_usuario="+id_usuario;
		((java.sql.Statement)consulta).executeUpdate(SQL);
		((java.sql.Statement)consulta).close();
		conex.desconectar();
		swBorrar=true;

			
			}catch(SQLException e){
				System.out.println("No se pudo eliminar el Usuario.");
			
		}
			}else{
				System.out.println("El usuario No existe.");
			}
			return swBorrar;
}
	public boolean actualizarUsuario(UsuarioVO Usuario){
		boolean swActualizar=false;
		if(existeUsuario(Usuario.getId_usuario())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="UPDATE usuario SET usuario='" +Usuario.getUsuario()+"',"+"password='"+Usuario.getPassword()+"',"
				+"cedula_usuario='"+Usuario.getCedula_usuario()+"', "+"nombre_usuario='"+Usuario.getNombre_usuario()+"',"
				+ "email_usuario='"+Usuario.getEmail_usuario()+"' WHERE id_usuario="+Usuario.getId_usuario();
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