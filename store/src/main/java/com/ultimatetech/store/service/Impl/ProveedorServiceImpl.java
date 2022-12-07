package com.ultimatetech.store.service.Impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.Proveedor;
import com.ultimatetech.store.repository.ProveedorRepository;
import com.ultimatetech.store.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	ProveedorRepository proveedorRepository;

	@Override
	public ArrayList<Proveedor> ListarProveedor() {
		// TODO Auto-generated method stub
		return (ArrayList<Proveedor>)proveedorRepository.findAll();
	}

	@Override
	public Optional<Proveedor> ProveedorById(long id) {
		// TODO Auto-generated method stub
		return proveedorRepository.findById(id);
	}

	@Override
	public Proveedor GuardarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorRepository.save(proveedor);
	}

	@Override
	public boolean EliminarProveedorById(long id) {
		// TODO Auto-generated method stub
		try {
			Optional<Proveedor>proveedor=ProveedorById(id);
			proveedorRepository.delete(proveedor.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	

}
