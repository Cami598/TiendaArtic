package com.DAO.login;

import  java.sql.Statement;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.login.ProveedorVO;

public class ProveedorDAO {
	public ArrayList<ProveedorVO> listaProveedores(){
		ArrayList<ProveedorVO> misProveedores =new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores ");
			ResultSet res= consulta.executeQuery();
		while(res.next()){
			ProveedorVO  Proveedor = new ProveedorVO();
			Proveedor.setNit(res.getLong("nit"));
			Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
			Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
			Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
			Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
		
			misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
			return misProveedores;
			}


	public ArrayList<ProveedorVO> buscarProveedor (long nit){
		ArrayList<ProveedorVO> misProveedores =new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try{
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nit=?");
			consulta.setLong(1,nit);	
			ResultSet res= consulta.executeQuery();
			while(res.next()){
				ProveedorVO  Proveedor = new ProveedorVO();
				Proveedor.setNit(res.getLong("nit"));
				Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
				Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e){
			System.out.println ("No  se pudo conectar");
			}
		return misProveedores;
			}
			
	 public boolean existeProveedor(long nit){
		boolean existe =false;
		Conexion conex = new Conexion();
		try{
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nit=?");
		consulta.setLong(1,  nit);
		ResultSet res= consulta.executeQuery();
			if(res.next()){
			existe=true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			}catch(Exception e){
			System.out.println("No se pudo verificar si existe el Proveedor.");
			}
			return existe;
	}
	public boolean crearProveedore(ProveedorVO Proveedor){
		boolean swCrear =false;
		if(!existeProveedor(Proveedor.getNit())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="INSERT INTO proveedores (nit, nombre_proveedor, direccion_proveedor, telefono_proveedor, ciudad_proveedor) VALUES("+
				Proveedor.getNit()+",'"+Proveedor.getNombre_proveedor()+"','"+Proveedor.getDireccion_proveedor()+"','"+Proveedor.getTelefono_proveedor()+"','"+Proveedor.getCiudad_proveedor()+"');";
		((java.sql.Statement) consulta).executeUpdate(SQL);
		((java.sql.Statement) consulta).close();
		conex.desconectar();
		swCrear=true;
			
			}catch(SQLException e){
				System.out.println("No se pudo crear el Proveedor.");
				
			}
		}else{
				System.out.println("El proveedor ya existe.");
			}
			return swCrear;
	}

	public boolean borrarProveedor(long nit){
		boolean swBorrar =false;
		if(existeProveedor(nit)){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="DELETE FROM proveedores WHERE nit="+nit;
		((java.sql.Statement)consulta).executeUpdate(SQL);
		((java.sql.Statement)consulta).close();
		conex.desconectar();
		swBorrar=true;

			
			}catch(SQLException e){
				System.out.println("No se pudo eliminar el Proveedor.");
			
		}
			}else{
				System.out.println("El Proveedor No existe.");
			}
			return swBorrar;
}
	public boolean actualizarProveedor(ProveedorVO Proveedor){
		boolean swActualizar=false;
		if(existeProveedor(Proveedor.getNit())){

		Conexion conex = new Conexion();
		try{
		Statement consulta = (Statement) conex.getConnection().createStatement();
		String SQL="UPDATE proveedores SET nit='" +Proveedor.getNit()+"',"+"nombre_proveedor='"+Proveedor.getNombre_proveedor()+"',"
				+"direccion_proveedor='"+Proveedor.getDireccion_proveedor()+"', "+"telefono_proveedor='"+Proveedor.getTelefono_proveedor()+"',"
				+ "ciudad_proveedor='"+Proveedor.getCiudad_proveedor()+"' WHERE nit="+Proveedor.getNit();
		((java.sql.Statement) consulta).executeUpdate(SQL);
		((java.sql.Statement) consulta).close();
		conex.desconectar();
		swActualizar=true;
			
			}catch(SQLException e){
				System.out.println("No se pudo Actualizar el Proveedor.");
			}
		}else{
				System.out.println("El proveedor No existe.");
			}
			return swActualizar;
}
}
