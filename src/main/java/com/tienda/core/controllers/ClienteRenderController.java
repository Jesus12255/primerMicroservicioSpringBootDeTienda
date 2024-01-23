package com.tienda.core.controllers;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*controlador de pruebas para retornal el cliente en distintos formatos*/
@RestController
public class ClienteRenderController {
	
	@GetMapping(value = "/cliente-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public String getCliente() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("<xml>"); 
		sb.append("<cliente>");  
		sb.append("			<nombre>Nombre: Rafael Benedettelli</nombre>");
		sb.append("			<userName>UserName: RBL</userName>");
		sb.append("</cliente>"); 
		sb.append("<xml>");  
		
		return sb.toString(); 
	}
}
