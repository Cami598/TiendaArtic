package com.BO.login;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.login.UsuarioDAO;
import com.DTO.login.UsuarioVO;



@RestController 
public class UsuarioController { 
		
	
	
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		UsuarioDAO dao=new  UsuarioDAO();
		
		return dao.listaDeUsuarios();
	}
	
	@RequestMapping("/buscarusuarioID")
	public ArrayList<UsuarioVO> buscarUsuario(String id_usuario){
		UsuarioDAO dao=new UsuarioDAO();
		
		return dao.buscarUsuario(Long.parseLong(id_usuario));
	}
	@RequestMapping("/crearusuario")
	public boolean crearUsuario(String id_usuario, String usuario, String password, String cedula_usuario, String nombre_usuario, String email_usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario= new UsuarioVO();
		
		Usuario.setId_usuario(Long.parseLong(id_usuario));
		Usuario.setUsuario(usuario);
		Usuario.setPassword(password);
		Usuario.setCedula_usuario(cedula_usuario);
		Usuario.setNombre_usuario(nombre_usuario);
		Usuario.setEmail_usuario(email_usuario);
		
		return dao.crearUsuario(Usuario);
		
	}
	@RequestMapping("/borrarusuario")
	public boolean borrarrUsuario(String id_usuario) {
		UsuarioDAO dao=new  UsuarioDAO();
		return dao.borrarUsuario(Long.parseLong(id_usuario));
	}
	@RequestMapping("/actualizarusuario")
	public boolean actualizarUsuario(String id_usuario, String usuario, String password, String cedula_usuario, String nombre_usuario, String email_usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		
		UsuarioVO Usuario= new UsuarioVO();
		
		Usuario.setId_usuario(Long.parseLong(id_usuario));
		Usuario.setUsuario(usuario);
		Usuario.setPassword(password);
		Usuario.setCedula_usuario(cedula_usuario);
		Usuario.setNombre_usuario(nombre_usuario);
		Usuario.setEmail_usuario(email_usuario);
		
		return dao.actualizarUsuario(Usuario);
		
}
	
	
	}
