package com.ultimatetech.store.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ultimatetech.store.entity.Cliente;

public interface ClienteService {
	
	ArrayList<Cliente>ListarCliente();
	Optional<Cliente>ClienteById(long id);
	Cliente GuardarCliente(Cliente cliente);
	boolean EliminarClienteById(long id);
	
}
