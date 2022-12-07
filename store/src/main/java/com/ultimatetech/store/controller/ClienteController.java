package com.ultimatetech.store.controller;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultimatetech.store.entity.Cliente;
import com.ultimatetech.store.service.ClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;



	@GetMapping
	public ArrayList<Cliente>ListarCliente(){
		return clienteService.ListarCliente();
	}
	
	@GetMapping("/BuscarPorId/{id}")
public Optional<Cliente>ListarClientePorId(@PathVariable("id")long id){
		return clienteService.ClienteById(id);
	}
	
	
	
	@PostMapping("/Guardar")
	public Cliente GuardarCliente(@RequestBody Cliente cliente) {
		return clienteService.GuardarCliente(cliente);
}
	
	
	@DeleteMapping("/Eliminar/{id}")
	public String EliminarClientePorId(@PathVariable("id")long id) {
	if (clienteService.EliminarClienteById(id))
		return "se ha eliminado";
		
	else {
		return "no se ha elimnado";
	}
	
	}
   
}
