package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	@NotEmpty(message = "El nombre puede estar vacío")
	@Size(min = 4, max = 100, message = "El titulo no puede ser corto")
	private String titulo;
	@NotBlank(message = "Es necesario el consejo para los clientes")
	@Size(min = 15, max = 500, message = "El consejo debe ser mas largo")
	private String consejo;
	
	public Consejo() {
		
	}
	public Consejo(String titulo, String consejo) {
		this.titulo = titulo;
		this.consejo = consejo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getConsejo() {
		return consejo;
	}
	
	public void setConsejo(String consejo) {
		this.consejo = consejo;
	}

	
	}


