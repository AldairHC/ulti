package com.ultimatetech.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultimatetech.store.service.VentaService;

@RestController
@RequestMapping("ventas")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	 
}
