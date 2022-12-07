package com.ultimatetech.store.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.PersonaJuridica;
import com.ultimatetech.store.entity.PersonaNatural;
import com.ultimatetech.store.repository.PersonaJuridicaRepository;
import com.ultimatetech.store.repository.PersonaNaturalRepository;
import com.ultimatetech.store.service.PersonaJuridicaService;
import com.ultimatetech.store.service.PersonaNaturalService;

@Service
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService{


	@Autowired
	PersonaJuridicaRepository personaJuridicaRepository;


	@Override
	public List<PersonaJuridica> listar() {
		// TODO Auto-generated method stub
		return personaJuridicaRepository.findAll();
	}

	@Override
	public PersonaJuridica guardar(PersonaJuridica personaJuridica) {
		// TODO Auto-generated method stub
		return personaJuridicaRepository.save(personaJuridica);
	}

	@Override
	public PersonaJuridica actualizar(PersonaJuridica personaJuridica) {
		// TODO Auto-generated method stub
		return personaJuridicaRepository.save(personaJuridica);
	}

	@Override
	public void eliminar(Long codigo) {
		personaJuridicaRepository.deleteById(codigo);
		
	}

	@Override
	public PersonaJuridica listarPorId(Long codigo) {
		// TODO Auto-generated method stub
		return personaJuridicaRepository.findById(codigo).orElse(null);
	}

	
	
}
