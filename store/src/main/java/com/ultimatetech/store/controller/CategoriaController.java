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
import com.ultimatetech.store.entity.Categoria;
import com.ultimatetech.store.service.CategoriaService;

@RestController
@RequestMapping("categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
    CategoriaService categoriaService;
	
	@GetMapping("/Listar")
	public ResponseEntity<List<Categoria>>listar(){
		List<Categoria>objCategorias = categoriaService.listar();
		return new ResponseEntity<List<Categoria>>(objCategorias,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void>guardar(@RequestBody Categoria categoria){
		
		Categoria objCategoria = categoriaService.guardar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getIdCategoria()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Categoria>actualizar(@RequestBody Categoria categoria){
		
		Categoria objCategoria = categoriaService.actualizar(categoria);
		return new ResponseEntity<Categoria>(objCategoria, HttpStatus.OK);

	}

@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminar(@PathVariable("id") Long codigo) throws Exception{
		Categoria objCategoria = categoriaService.listarPorId(codigo);
		if (objCategoria==null) {
			throw new Exception("No se Encontro");
		}
		categoriaService.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>listarPorId(@PathVariable("id") Long codigo) throws Exception{
		Categoria objCategoria = categoriaService.listarPorId(codigo);
		if (objCategoria==null) {
			throw new Exception("No se Encontro");
		}
		return new ResponseEntity<Categoria>(objCategoria,HttpStatus.OK);
	}
	
}
