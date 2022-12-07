package com.ultimatetech.store.service;

import java.util.List;

import com.ultimatetech.store.entity.PersonaNatural;

public interface PersonaNaturalService {

	List<PersonaNatural>listar();
	PersonaNatural guardar(PersonaNatural personaNatural);
	PersonaNatural actualizar(PersonaNatural personaNatural);
	void eliminar(Long codigo);
	PersonaNatural listarPorId(Long codigo);
}
