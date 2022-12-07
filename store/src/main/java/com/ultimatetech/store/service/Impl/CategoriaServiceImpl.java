package com.ultimatetech.store.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ultimatetech.store.entity.Categoria;
import com.ultimatetech.store.repository.CategoriaRepository;
import com.ultimatetech.store.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria actualizar(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public void eliminar(Long codigo) {
		categoriaRepository.deleteById(codigo);
		
	}

	@Override
	public Categoria listarPorId(Long codigo) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(codigo).orElse(null);
	}

	

}
