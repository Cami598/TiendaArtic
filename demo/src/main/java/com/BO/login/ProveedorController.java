package com.BO.login;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.login.ProveedorDAO;
import com.DTO.login.ProveedorVO;

@RestController
public class ProveedorController {
	@RequestMapping("/listaproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ProveedorDAO dao=new  ProveedorDAO();
		
		return dao.listaProveedores();
	}
	
	@RequestMapping("/buscarproveedor")
	public ArrayList<ProveedorVO> buscarProveesor(String nit){
		ProveedorDAO dao=new  ProveedorDAO();
		
		return dao.buscarProveedor(Long.parseLong(nit));
	}
	@RequestMapping("/crearproveedor")
	public boolean crearProveedor(String nit, String nombre_proveedor, String direccion_proveedor, String telefono_proveedor, String ciudad_proveedor) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor= new ProveedorVO();
		
		Proveedor.setNit(Long.parseLong(nit));
		Proveedor.setNombre_proveedor(nombre_proveedor);
		Proveedor.setDireccion_proveedor(direccion_proveedor);
		Proveedor.setTelefono_proveedor(telefono_proveedor);
		Proveedor.setCiudad_proveedor(ciudad_proveedor);
		
		
		return dao.crearProveedore(Proveedor);
		
	}
	@RequestMapping("/borrarproveedor")
	public boolean borrarProveedor(String nit) {
		ProveedorDAO dao=new  ProveedorDAO();
		return dao.borrarProveedor(Long.parseLong(nit));
	}
	@RequestMapping("/actualizarproveedor")
	public boolean actualizarProveedor(String nit, String nombre_proveedor, String direccion_proveedor, String telefono_proveedor, String ciudad_proveedor) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor= new ProveedorVO();
		
		Proveedor.setNit(Long.parseLong(nit));
		Proveedor.setNombre_proveedor(nombre_proveedor);
		Proveedor.setDireccion_proveedor(direccion_proveedor);
		Proveedor.setTelefono_proveedor(telefono_proveedor);
		Proveedor.setCiudad_proveedor(ciudad_proveedor);
		
		return dao.actualizarProveedor(Proveedor);
		
}
}
