package com.ultimatetech.store.service.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.Cliente;
import com.ultimatetech.store.repository.ClienteRepository;
import com.ultimatetech.store.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	

	@Override
	public ArrayList<Cliente> ListarCliente() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>)clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> ClienteById(long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente GuardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public boolean EliminarClienteById(long id) {
		// TODO Auto-generated method stub
		try {
			Optional<Cliente>cliente=ClienteById(id);
			clienteRepository.delete(cliente.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
