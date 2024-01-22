package com.tienda.core.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.core.domain.Cliente;
import com.tienda.core.exceptions.BadRequestException;
import com.tienda.core.exceptions.ResourceNotFoundException;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

	private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
			new Cliente("pep", "123", "pepe"),
			new Cliente("pac", "123", "paco"), 
			new Cliente("aaa", "123", "aa")));
	
	@GetMapping
	public ResponseEntity<?> getClientes(){
		return ResponseEntity.ok(clientes); 
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<?> getCliente(@PathVariable  String userName) {
		
		if (userName.length()!=3) {
			throw new BadRequestException("El parámetro nombre de usuario debe contener 3 caracteres");
		}
		
		return clientes.stream()
				.filter(cliente -> cliente.getUserName().equalsIgnoreCase(userName))
				.findFirst()
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente " + userName + " no encontrado."));
		
	}
	
	@PostMapping
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		
		//Obteniendo URL de servicio
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{userName}")
				.buildAndExpand(cliente.getUserName())
				.toUri();
		return cliente; 
	}
	
	@PutMapping
	public ResponseEntity<?> modificacionCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteEncontrado = clientes.stream().
				filter(cli -> cli.getUserName().equalsIgnoreCase(cliente.getUserName())).
				findFirst().orElseThrow();
		clienteEncontrado.setPassword(cliente.getPassword()); 
		clienteEncontrado.setNombre(cliente.getNombre());
		
		return  ResponseEntity.ok(clienteEncontrado);
	}
	
	@DeleteMapping("/{userName}")
	public ResponseEntity eliminacionCliente(@PathVariable String userName) {
		
		Cliente clienteEncontrado = clientes.stream().
				filter(cl -> cl.getUserName().equalsIgnoreCase(userName)).
				findFirst().orElseThrow();
		
		clientes.remove(clienteEncontrado); 
		return ResponseEntity.noContent().build();
	}
}
