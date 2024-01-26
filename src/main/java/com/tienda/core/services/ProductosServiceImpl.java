package com.tienda.core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.core.domain.Producto;

@Service
public class ProductosServiceImpl implements ProductoServices{
	private List<Producto> productos = new ArrayList<>(Arrays.asList(
			new Producto(1, "p01", 1.0, 1), 
			new Producto(2, "p01", 1.0, 1), 
			new Producto(3, "p01", 1.0, 1)));
	


	@Override
	public List<Producto> getProductos() {
		return productos;
	}
	
}
