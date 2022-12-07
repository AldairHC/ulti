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
import com.ultimatetech.store.entity.PersonaJuridica;
import com.ultimatetech.store.service.PersonaJuridicaService;


@RestController
@RequestMapping("persona_juridica")
@CrossOrigin("*")
public class PersonaJuridicaController {
	
	@Autowired
    PersonaJuridicaService personaJuridicaService;

	@GetMapping
	public ResponseEntity<List<PersonaJuridica>>listar(){
		List<PersonaJuridica>objPersonaJuridica = personaJuridicaService.listar();
		return new ResponseEntity<List<PersonaJuridica>>(objPersonaJuridica,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void>guardar(@RequestBody PersonaJuridica personaJuridica){
		
		PersonaJuridica objPersonaJuridica = personaJuridicaService.guardar(personaJuridica);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPersonaJuridica.getRuc()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<PersonaJuridica>actualizar(@RequestBody PersonaJuridica personaJuridica){
		
		PersonaJuridica objPersonaJuridica = personaJuridicaService.actualizar(personaJuridica);
		return new ResponseEntity<PersonaJuridica>(objPersonaJuridica, HttpStatus.OK);

	}

@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminar(@PathVariable("id") Long codigo) throws Exception{
		PersonaJuridica objPersonaJuridica = personaJuridicaService.listarPorId(codigo);
		if (objPersonaJuridica==null) {
			throw new Exception("No se Encontro");
		}
		personaJuridicaService.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaJuridica>listarPorId(@PathVariable("id") Long codigo) throws Exception{
		PersonaJuridica objPersonaJuridica = personaJuridicaService.listarPorId(codigo);
		if (objPersonaJuridica==null) {
			throw new Exception("No se Encontro");
		}
		return new ResponseEntity<PersonaJuridica>(objPersonaJuridica,HttpStatus.OK);
	}
	
}
