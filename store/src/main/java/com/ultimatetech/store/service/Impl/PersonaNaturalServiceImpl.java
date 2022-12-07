package com.ultimatetech.store.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatetech.store.entity.PersonaNatural;
import com.ultimatetech.store.repository.PersonaNaturalRepository;
import com.ultimatetech.store.service.PersonaNaturalService;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService{

	@Autowired
	PersonaNaturalRepository personaNaturalRepository;


	@Override
	public List<PersonaNatural> listar() {
		// TODO Auto-generated method stub
		return personaNaturalRepository.findAll();
	}

	@Override
	public PersonaNatural guardar(PersonaNatural personaNatural) {
		// TODO Auto-generated method stub
		return personaNaturalRepository.save(personaNatural);
	}

	@Override
	public PersonaNatural actualizar(PersonaNatural personaNatural) {
		// TODO Auto-generated method stub
		return personaNaturalRepository.save(personaNatural);
	}

	@Override
	public void eliminar(Long codigo) {
		personaNaturalRepository.deleteById(codigo);
		
	}

	@Override
	public PersonaNatural listarPorId(Long codigo) {
		// TODO Auto-generated method stub
		return personaNaturalRepository.findById(codigo).orElse(null);
	}

	
	
}
