package com.tienda.core.controllers;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*controlador de pruebas para retornal el cliente en distintos formatos*/
@RestController
public class ClienteRenderController {
	
	@GetMapping(value = "/cliente-html", produces = MediaType.TEXT_HTML_VALUE)
	public String getCliente() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("<html>");
		sb.append("<body>"); 
		sb.append("	<div><h1>Cliente</h1>"); 
		sb.append("		<ul>"); 
		sb.append("			<li>Nombre: Rafael Benedettelli</li>");
		sb.append("			<li>UserName: RBL</li>");
		sb.append("		</ul>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>"); 
		
		return sb.toString(); 
	}
}
