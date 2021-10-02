package com.BO.login;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.login.*;
import com.DTO.login.loginVO;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class loginController {
	
	// devuelve true o false si existe el usuario
	@RequestMapping("/loginusuario2")
	//public Map<String, Boolean> validarlogin2(String usuario, String password)
	//recibe esta cadena y convierte en un objeto de tipo cliente
	public ArrayList<loginVO> validarlogin2(String usuario, String password){
	{
	ArrayList<loginVO> miusuario = new ArrayList<loginVO>();
	//Crea el objeto arryList

	//pasa la peteción al servicio
	loginDAO Dao=new loginDAO(); 
	//cargamos el objeto y se pasa al DAO y valida el usuario
	miusuario= Dao.consultarUsuario(usuario, password);
	return miusuario;
	
	
	
}}}