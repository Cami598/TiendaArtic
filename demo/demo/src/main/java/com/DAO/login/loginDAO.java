package com.DAO.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import com.DTO.login.loginVO;

public class loginDAO {
	public ArrayList<loginVO> consultarUsuario(String usuario, String password) {
		ArrayList<loginVO> miusuario = new ArrayList<loginVO>();
		

		Conexion conex= new Conexion();
		try {
		String cadenaSQL="SELECT * FROM usuario where usuario =? and password=?";

		PreparedStatement consulta =
		conex.getConnection().prepareStatement(cadenaSQL);

		consulta.setString(1, usuario);//el orden de los ?
		consulta.setString(2, password);

		ResultSet res = consulta.executeQuery();

		if(res.next()){
		loginVO usuario1= new loginVO();
		usuario1.setUsuario(res.getString("usuario"));
		//lee la BD

		usuario1.setPassword(res.getString("password"));
		miusuario.add(usuario1);
		//agregar a la lista el usuario encontrado en la BD

		}
		res.close();
		consulta.close();
		conex.desconectar();
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "no se pudo consultar El usuario\n"+e);

		}
		return miusuario;
		}

		}


