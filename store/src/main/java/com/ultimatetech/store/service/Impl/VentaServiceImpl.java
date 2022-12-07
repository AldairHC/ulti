package com.ultimatetech.store.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.Venta;
import com.ultimatetech.store.repository.VentaRepository;
import com.ultimatetech.store.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	VentaRepository ventaRepository;
	
	@Override
	public List<Venta> listarVentas() {
		return this.ventaRepository.findAll();
	}

}
