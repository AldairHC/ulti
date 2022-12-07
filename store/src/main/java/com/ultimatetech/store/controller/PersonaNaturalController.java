package com.ultimatetech.store.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ultimatetech.store.entity.PersonaNatural;
import com.ultimatetech.store.service.PersonaNaturalService;

@RestController
@RequestMapping("persona_natural")
@CrossOrigin("*")
public class PersonaNaturalController {
	
	@Autowired
    PersonaNaturalService personaNaturalService;

	@GetMapping
	public ResponseEntity<List<PersonaNatural>>listar(){
		List<PersonaNatural>objPersonaNatural = personaNaturalService.listar();
		return new ResponseEntity<List<PersonaNatural>>(objPersonaNatural,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void>guardar(@RequestBody PersonaNatural personaNatural){
		
		PersonaNatural objPersonaNatural = personaNaturalService.guardar(personaNatural);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPersonaNatural.getDni()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<PersonaNatural>actualizar(@RequestBody PersonaNatural personaNatural){
		
		PersonaNatural objPersonaNatural = personaNaturalService.actualizar(personaNatural);
		return new ResponseEntity<PersonaNatural>(objPersonaNatural, HttpStatus.OK);

	}

@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminar(@PathVariable("id") Long codigo) throws Exception{
		PersonaNatural objPersonaNatural = personaNaturalService.listarPorId(codigo);
		if (objPersonaNatural==null) {
			throw new Exception("No se Encontro");
		}
		personaNaturalService.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaNatural>listarPorId(@PathVariable("id") Long codigo) throws Exception{
		PersonaNatural objPersonaNatural = personaNaturalService.listarPorId(codigo);
		if (objPersonaNatural==null) {
			throw new Exception("No se Encontro");
		}
		return new ResponseEntity<PersonaNatural>(objPersonaNatural,HttpStatus.OK);
	}
	
}
