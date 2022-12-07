package com.ultimatetech.store.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.Producto;
import com.ultimatetech.store.repository.ProductoRepository;
import com.ultimatetech.store.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto guardar(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizar(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public void eliminar(Long codigo) {
		productoRepository.deleteById(codigo);
		
	}

	@Override
	public Producto listarPorId(Long codigo) {
		// TODO Auto-generated method stub
		return productoRepository.findById(codigo).orElse(null);
	}

	
	
	

}
