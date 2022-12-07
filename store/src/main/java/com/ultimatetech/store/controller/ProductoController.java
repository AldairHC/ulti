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

import com.ultimatetech.store.entity.Producto;
import com.ultimatetech.store.service.ProductoService;

@RestController
@RequestMapping("producto")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>>listar(){
		List<Producto>objProducto = productoService.listar();
		return new ResponseEntity<List<Producto>>(objProducto,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void>guardar(@RequestBody Producto producto){
		
		Producto objProducto = productoService.guardar(producto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objProducto.getCodProducto()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Producto>actualizar(@RequestBody Producto producto){
		
		Producto objProducto = productoService.actualizar(producto);
		return new ResponseEntity<Producto>(objProducto, HttpStatus.OK);

	}

@DeleteMapping("/{id}")
	public ResponseEntity<Void>eliminar(@PathVariable("id") Long codigo) throws Exception{
		Producto objProducto = productoService.listarPorId(codigo);
		if (objProducto==null) {
			throw new Exception("No se Encontro");
		}
		productoService.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto>listarPorId(@PathVariable("id") Long codigo) throws Exception{
		Producto objProducto = productoService.listarPorId(codigo);
		if (objProducto==null) {
			throw new Exception("No se Encontro");
		}
		return new ResponseEntity<Producto>(objProducto,HttpStatus.OK);
	}
	
}
