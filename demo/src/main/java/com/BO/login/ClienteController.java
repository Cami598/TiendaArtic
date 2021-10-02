package com.BO.login;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.login.ClienteDAO;
import com.DTO.login.ClienteVO;



@RestController 

public class ClienteController {

	@RequestMapping("/listaclientes")
	public ArrayList<ClienteVO> listaDeClientes(){
		ClienteDAO dao=new  ClienteDAO();
		
		return dao.listaClientes();
	}
	
	@RequestMapping("/buscarcliente")
	public ArrayList<ClienteVO> buscarCliente(String cedula_cliente){
		ClienteDAO dao=new  ClienteDAO();
		
		return dao.buscarCliente(Long.parseLong(cedula_cliente));
	}
	@RequestMapping("/crearcliente")
	public boolean crearCliente(String cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente, String telefono_cliente) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente= new ClienteVO();
		
		Cliente.setCedula_cliente(Long.parseLong(cedula_cliente));
		Cliente.setDireccion_cliente(direccion_cliente);
		Cliente.setEmail_cliente (email_cliente);
		Cliente.setNombre_cliente(nombre_cliente);
		Cliente.setTelefono_cliente(telefono_cliente);
		
		
		return dao.crearCliente(Cliente);
		
	}
	@RequestMapping("/borrarcliente")
	public boolean borrarCliente(String cedula_cliente) {
		ClienteDAO dao=new  ClienteDAO();
		return dao.borrarCliente(Long.parseLong(cedula_cliente));
	}
	@RequestMapping("/actualizarcliente")
	public boolean actualizarCliente(String cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente, String telefono_cliente) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente= new ClienteVO();
		
		Cliente.setCedula_cliente(Long.parseLong(cedula_cliente));
		Cliente.setDireccion_cliente(direccion_cliente);
		Cliente.setEmail_cliente (email_cliente);
		Cliente.setNombre_cliente(nombre_cliente);
		Cliente.setTelefono_cliente(telefono_cliente);
		
		return dao.actualizarCliente(Cliente);
		
}
}
