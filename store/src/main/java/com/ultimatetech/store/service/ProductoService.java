package com.ultimatetech.store.service;
import java.util.List;


import com.ultimatetech.store.entity.Producto;

public interface ProductoService {
	List<Producto>listar();
	Producto guardar(Producto producto);
	Producto actualizar(Producto producto);
	void eliminar(Long codigo);
	Producto listarPorId(Long codigo);
}
