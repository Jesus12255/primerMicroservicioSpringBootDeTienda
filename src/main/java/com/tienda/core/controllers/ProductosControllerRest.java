package com.tienda.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.core.services.ProductosServiceImpl;

@RestController
@RequestMapping("/productos")
public class ProductosControllerRest {
	
	@Autowired
	private ProductosServiceImpl productosService; 

	@GetMapping
	public ResponseEntity<?> getProductos(){
		return ResponseEntity.ok(productosService.getProductos()); 
	}
}
