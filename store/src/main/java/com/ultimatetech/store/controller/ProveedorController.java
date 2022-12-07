package com.ultimatetech.store.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultimatetech.store.entity.Proveedor;
import com.ultimatetech.store.service.ProveedorService;

@RestController
@RequestMapping("proveedor")
public class ProveedorController {
	

	@Autowired
    private ProveedorService proveedorService;
	
	@GetMapping("/Listar")
	public ArrayList<Proveedor>ListarProveedor(){
		return proveedorService.ListarProveedor();
	}
	
	@GetMapping("/BuscarPorId/{id}")
public Optional<Proveedor>ListarProveedorPorId(@PathVariable("id")long id){
		return proveedorService.ProveedorById(id);
	}
	
	
	
	@PostMapping("/Guardar")
	public Proveedor GuardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorService.GuardarProveedor(proveedor);
}
	
	
	@DeleteMapping("/Eliminar/{id}")
	public String EliminarProveedorPorId(@PathVariable("id")long id) {
	if (proveedorService.EliminarProveedorById(id))
		return "se ha eliminado";
		
	else {
		return "no se ha elimnado";
	}
	
}
	
	
}
