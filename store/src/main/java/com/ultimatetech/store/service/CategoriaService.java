package com.ultimatetech.store.service;

import java.util.List;
import com.ultimatetech.store.entity.Categoria;

public interface CategoriaService {
	
	List<Categoria>listar();
	Categoria guardar(Categoria categoria);
	Categoria actualizar(Categoria categoria);
	void eliminar(Long codigo);
	Categoria listarPorId(Long codigo);
	
}
