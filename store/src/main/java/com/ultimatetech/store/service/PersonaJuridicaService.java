package com.ultimatetech.store.service;

import java.util.List;
import com.ultimatetech.store.entity.PersonaJuridica;


public interface PersonaJuridicaService {

	List<PersonaJuridica>listar();
	PersonaJuridica guardar(PersonaJuridica personaJuridica);
	PersonaJuridica actualizar(PersonaJuridica personaJuridica);
	void eliminar(Long codigo);
	PersonaJuridica listarPorId(Long codigo);;
}
